
// Description: Spring Ram storage tests for CFInt for the RamTest program

/*
 *	server.markhome.mcf.CFBam
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFBam - Business Application Model
 *	
 *	This file is part of Mark's Code Fractal CFBam.
 *	
 *	Mark's Code Fractal CFBam is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU General Public License,
 *	Version 3 or later.
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
 *	
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
import server.markhome.mcf.v3_1.cfint.cfint.*;
import server.markhome.mcf.v3_1.cfint.cfint.buff.*;
import server.markhome.mcf.v3_1.cfint.cfintram.*;

@Service("RamTestCFInt")
public class CFIntRamTestTestSchema {
    
    public String performTests(EntityManager em) {
		StringBuffer messages = new StringBuffer("Starting CFInt tests...\n");
		ICFIntLicense[] licenseResults = ICFIntSchema.getBackingCFInt().getTableLicense().readAllDerived(null);
		if (licenseResults == null) {
			messages.append("Erroneously retrieved null for ICFIntSchema.getLicenseTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + licenseResults.length + " entities from CFInt.License\n");
		}

		ICFIntMajorVersion[] majorVersionResults = ICFIntSchema.getBackingCFInt().getTableMajorVersion().readAllDerived(null);
		if (majorVersionResults == null) {
			messages.append("Erroneously retrieved null for ICFIntSchema.getMajorVersionTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + majorVersionResults.length + " entities from CFInt.MajorVersion\n");
		}

		ICFIntMimeType[] mimeTypeResults = ICFIntSchema.getBackingCFInt().getTableMimeType().readAllDerived(null);
		if (mimeTypeResults == null) {
			messages.append("Erroneously retrieved null for ICFIntSchema.getMimeTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + mimeTypeResults.length + " entities from CFInt.MimeType\n");
		}

		ICFIntMinorVersion[] minorVersionResults = ICFIntSchema.getBackingCFInt().getTableMinorVersion().readAllDerived(null);
		if (minorVersionResults == null) {
			messages.append("Erroneously retrieved null for ICFIntSchema.getMinorVersionTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + minorVersionResults.length + " entities from CFInt.MinorVersion\n");
		}

		ICFIntSubProject[] subProjectResults = ICFIntSchema.getBackingCFInt().getTableSubProject().readAllDerived(null);
		if (subProjectResults == null) {
			messages.append("Erroneously retrieved null for ICFIntSchema.getSubProjectTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + subProjectResults.length + " entities from CFInt.SubProject\n");
		}

		ICFIntTld[] tldResults = ICFIntSchema.getBackingCFInt().getTableTld().readAllDerived(null);
		if (tldResults == null) {
			messages.append("Erroneously retrieved null for ICFIntSchema.getTldTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tldResults.length + " entities from CFInt.Tld\n");
		}

		ICFIntTopDomain[] topDomainResults = ICFIntSchema.getBackingCFInt().getTableTopDomain().readAllDerived(null);
		if (topDomainResults == null) {
			messages.append("Erroneously retrieved null for ICFIntSchema.getTopDomainTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + topDomainResults.length + " entities from CFInt.TopDomain\n");
		}

		ICFIntTopProject[] topProjectResults = ICFIntSchema.getBackingCFInt().getTableTopProject().readAllDerived(null);
		if (topProjectResults == null) {
			messages.append("Erroneously retrieved null for ICFIntSchema.getTopProjectTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + topProjectResults.length + " entities from CFInt.TopProject\n");
		}

		ICFIntURLProtocol[] uRLProtocolResults = ICFIntSchema.getBackingCFInt().getTableURLProtocol().readAllDerived(null);
		if (uRLProtocolResults == null) {
			messages.append("Erroneously retrieved null for ICFIntSchema.getURLProtocolTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uRLProtocolResults.length + " entities from CFInt.URLProtocol\n");
		}

		messages.append("CFInt tests complete\n");
		return( messages.toString() );
	}
}