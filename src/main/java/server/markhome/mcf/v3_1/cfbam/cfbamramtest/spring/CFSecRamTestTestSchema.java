
// Description: Spring Ram storage tests for CFSec for the RamTest program

/*
 *	server.markhome.mcf.CFBam
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal CFBam 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Mark's Code Fractal CFBam.
 *	
 *	Mark's Code Fractal CFBam is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU General Public License,
 *	Version 3 or later with classpath and static linking exceptions.
 *	
 *	As a special exception, Mark Sobkow gives you permission to link this library
 *	with independent modules to produce an executable, provided that none of them
 *	conflict with the intent of the GPLv3; that is, you are not allowed to invoke
 *	the methods of this library from non-GPLv3-compatibly licensed code. You may not
 *	implement an LPGLv3 "wedge" to try to bypass this restriction. That said, code which
 *	does not rely on this library is free to specify whatever license its authors decide
 *	to use. Mark Sobkow specifically rejects the infectious nature of the GPLv3, and
 *	considers the mere act of including GPLv3 modules in an executable to be perfectly
 *	reasonable given tools like modern Java's single-jar deployment options.
 *	
 *	Mark's Code Fractal CFBam is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Mark's Code Fractal CFBam is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Mark's Code Fractal CFBam.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.mcf.v3_1.cfbam.cfbamramtest.spring;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;
import server.markhome.mcf.v3_1.cfsec.cfsec.buff.*;
import server.markhome.mcf.v3_1.cfsec.cfsecram.*;

@Service("RamTestCFSec")
public class CFSecRamTestTestSchema {
    
    public String performTests(EntityManager em) {
		StringBuffer messages = new StringBuffer("Starting CFSec tests...\n");
		{
			try {
				LocalDateTime now = LocalDateTime.now();
				CFLibDbKeyHash256 adminpid = new CFLibDbKeyHash256("f012301230123012301230123012301230123012301230123012301230123012");
				CFLibDbKeyHash256 mgrpid =   new CFLibDbKeyHash256("fabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabc");
				ICFSecSecUser secUserResults = ICFSecSchema.getBackingCFSec().getTableSecUser().readDerived(null, adminpid);
				if( secUserResults == null ) {
					CFSecBuffSecUser newuser = (CFSecBuffSecUser)(ICFSecSchema.getBackingCFSec().getFactorySecUser().newRec());
					newuser.setCreatedByUserId( adminpid );
					newuser.setCreatedAt( now );
					newuser.setUpdatedByUserId( adminpid );
					newuser.setUpdatedAt( now );
					newuser.setPKey(adminpid);
					newuser.setRequiredSecUserId( adminpid );
					newuser.setRequiredRevision( 1 );
					newuser.setOptionalLookupDefDev((ICFSecSecDevice)null);
					newuser.setRequiredLoginId( "admin" );
					newuser.setRequiredEMailAddress("admin@localhost");
					newuser.setOptionalEMailConfirmUuid6( null );
					newuser.setRequiredPasswordHash( computeSHA256("changeoninstall") );
					newuser.setOptionalPasswordResetUuid6( null );
					ICFSecSecUser secUserCreated = ICFSecSchema.getBackingCFSec().getTableSecUser().createSecUser(null, newuser);
					if (secUserCreated == null) {
						messages.append("Error creating secuser admin - null returned\n");
					}
					else {
						messages.append("Created admin user: " + secUserCreated.toString() + "\n");
					}
				}
				else {
					messages.append("Admin user already exists: " + secUserResults.toString() + "\n");
				}
			}
			catch (Exception e) {
				String msg = "ERROR: performTests() Caught and rethrew " + e.getClass().getCanonicalName() + " while modifying or creating the 'admin' user - " + e.getMessage();
				messages.append(msg);
				System.err.println(msg);
				e.printStackTrace(System.err);
			}
		}

		ICFSecCluster[] clusterResults = ICFSecSchema.getBackingCFSec().getTableCluster().readAllDerived(null);
		if (clusterResults == null) {
			messages.append("Erroneously retrieved null for ICFSecSchema.getClusterTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + clusterResults.length + " entities from CFSec.Cluster\n");
		}

		ICFSecHostNode[] hostNodeResults = ICFSecSchema.getBackingCFSec().getTableHostNode().readAllDerived(null);
		if (hostNodeResults == null) {
			messages.append("Erroneously retrieved null for ICFSecSchema.getHostNodeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + hostNodeResults.length + " entities from CFSec.HostNode\n");
		}

		ICFSecISOCcy[] iSOCcyResults = ICFSecSchema.getBackingCFSec().getTableISOCcy().readAllDerived(null);
		if (iSOCcyResults == null) {
			messages.append("Erroneously retrieved null for ICFSecSchema.getISOCcyTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + iSOCcyResults.length + " entities from CFSec.ISOCcy\n");
		}

		ICFSecISOCtry[] iSOCtryResults = ICFSecSchema.getBackingCFSec().getTableISOCtry().readAllDerived(null);
		if (iSOCtryResults == null) {
			messages.append("Erroneously retrieved null for ICFSecSchema.getISOCtryTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + iSOCtryResults.length + " entities from CFSec.ISOCtry\n");
		}

		ICFSecISOCtryCcy[] iSOCtryCcyResults = ICFSecSchema.getBackingCFSec().getTableISOCtryCcy().readAllDerived(null);
		if (iSOCtryCcyResults == null) {
			messages.append("Erroneously retrieved null for ICFSecSchema.getISOCtryCcyTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + iSOCtryCcyResults.length + " entities from CFSec.ISOCtryCcy\n");
		}

		ICFSecISOCtryLang[] iSOCtryLangResults = ICFSecSchema.getBackingCFSec().getTableISOCtryLang().readAllDerived(null);
		if (iSOCtryLangResults == null) {
			messages.append("Erroneously retrieved null for ICFSecSchema.getISOCtryLangTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + iSOCtryLangResults.length + " entities from CFSec.ISOCtryLang\n");
		}

		ICFSecISOLang[] iSOLangResults = ICFSecSchema.getBackingCFSec().getTableISOLang().readAllDerived(null);
		if (iSOLangResults == null) {
			messages.append("Erroneously retrieved null for ICFSecSchema.getISOLangTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + iSOLangResults.length + " entities from CFSec.ISOLang\n");
		}

		ICFSecISOTZone[] iSOTZoneResults = ICFSecSchema.getBackingCFSec().getTableISOTZone().readAllDerived(null);
		if (iSOTZoneResults == null) {
			messages.append("Erroneously retrieved null for ICFSecSchema.getISOTZoneTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + iSOTZoneResults.length + " entities from CFSec.ISOTZone\n");
		}

		ICFSecSecDevice[] secDeviceResults = ICFSecSchema.getBackingCFSec().getTableSecDevice().readAllDerived(null);
		if (secDeviceResults == null) {
			messages.append("Erroneously retrieved null for ICFSecSchema.getSecDeviceTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secDeviceResults.length + " entities from CFSec.SecDevice\n");
		}

		ICFSecSecGroup[] secGroupResults = ICFSecSchema.getBackingCFSec().getTableSecGroup().readAllDerived(null);
		if (secGroupResults == null) {
			messages.append("Erroneously retrieved null for ICFSecSchema.getSecGroupTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secGroupResults.length + " entities from CFSec.SecGroup\n");
		}

		ICFSecSecGrpInc[] secGrpIncResults = ICFSecSchema.getBackingCFSec().getTableSecGrpInc().readAllDerived(null);
		if (secGrpIncResults == null) {
			messages.append("Erroneously retrieved null for ICFSecSchema.getSecGrpIncTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secGrpIncResults.length + " entities from CFSec.SecGrpInc\n");
		}

		ICFSecSecGrpMemb[] secGrpMembResults = ICFSecSchema.getBackingCFSec().getTableSecGrpMemb().readAllDerived(null);
		if (secGrpMembResults == null) {
			messages.append("Erroneously retrieved null for ICFSecSchema.getSecGrpMembTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secGrpMembResults.length + " entities from CFSec.SecGrpMemb\n");
		}

		ICFSecSecSession[] secSessionResults = ICFSecSchema.getBackingCFSec().getTableSecSession().readAllDerived(null);
		if (secSessionResults == null) {
			messages.append("Erroneously retrieved null for ICFSecSchema.getSecSessionTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secSessionResults.length + " entities from CFSec.SecSession\n");
		}

		ICFSecSecUser[] secUserResults = ICFSecSchema.getBackingCFSec().getTableSecUser().readAllDerived(null);
		if (secUserResults == null) {
			messages.append("Erroneously retrieved null for ICFSecSchema.getSecUserTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + secUserResults.length + " entities from CFSec.SecUser\n");
		}

		ICFSecService[] serviceResults = ICFSecSchema.getBackingCFSec().getTableService().readAllDerived(null);
		if (serviceResults == null) {
			messages.append("Erroneously retrieved null for ICFSecSchema.getServiceTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + serviceResults.length + " entities from CFSec.Service\n");
		}

		ICFSecServiceType[] serviceTypeResults = ICFSecSchema.getBackingCFSec().getTableServiceType().readAllDerived(null);
		if (serviceTypeResults == null) {
			messages.append("Erroneously retrieved null for ICFSecSchema.getServiceTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + serviceTypeResults.length + " entities from CFSec.ServiceType\n");
		}

		ICFSecSysCluster[] sysClusterResults = ICFSecSchema.getBackingCFSec().getTableSysCluster().readAllDerived(null);
		if (sysClusterResults == null) {
			messages.append("Erroneously retrieved null for ICFSecSchema.getSysClusterTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + sysClusterResults.length + " entities from CFSec.SysCluster\n");
		}

		ICFSecTenant[] tenantResults = ICFSecSchema.getBackingCFSec().getTableTenant().readAllDerived(null);
		if (tenantResults == null) {
			messages.append("Erroneously retrieved null for ICFSecSchema.getTenantTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tenantResults.length + " entities from CFSec.Tenant\n");
		}

		ICFSecTSecGroup[] tSecGroupResults = ICFSecSchema.getBackingCFSec().getTableTSecGroup().readAllDerived(null);
		if (tSecGroupResults == null) {
			messages.append("Erroneously retrieved null for ICFSecSchema.getTSecGroupTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tSecGroupResults.length + " entities from CFSec.TSecGroup\n");
		}

		ICFSecTSecGrpInc[] tSecGrpIncResults = ICFSecSchema.getBackingCFSec().getTableTSecGrpInc().readAllDerived(null);
		if (tSecGrpIncResults == null) {
			messages.append("Erroneously retrieved null for ICFSecSchema.getTSecGrpIncTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tSecGrpIncResults.length + " entities from CFSec.TSecGrpInc\n");
		}

		ICFSecTSecGrpMemb[] tSecGrpMembResults = ICFSecSchema.getBackingCFSec().getTableTSecGrpMemb().readAllDerived(null);
		if (tSecGrpMembResults == null) {
			messages.append("Erroneously retrieved null for ICFSecSchema.getTSecGrpMembTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tSecGrpMembResults.length + " entities from CFSec.TSecGrpMemb\n");
		}

		messages.append("CFSec tests complete\n");
		return( messages.toString() );
	}

	// From Google's AI
    /**
     * Computes the SHA-256 hash of a given string and returns it as a hex string.
     *
     * @param text The input string to hash.
     * @return The SHA-256 hash in hexadecimal format.
     */
    public static String computeSHA256(String text) {
        try {
            // Step 1: Get a MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Step 2: Convert the input string to bytes using UTF-8 encoding
            byte[] hashBytes = digest.digest(text.getBytes(StandardCharsets.UTF_8));

            // Step 3: Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                // Convert byte to hex (ensure two characters per byte)
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            // Handle the case where the algorithm is not available (highly unlikely for SHA-256)
            throw new RuntimeException("SHA-256 algorithm not available", e);
        }
    }
}