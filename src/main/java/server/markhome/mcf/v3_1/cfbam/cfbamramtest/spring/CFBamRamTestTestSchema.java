
// Description: Spring Ram storage tests for CFBam for the RamTest program

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
import server.markhome.mcf.v3_1.cfint.cfint.*;
import server.markhome.mcf.v3_1.cfsec.cfsec.buff.*;
import server.markhome.mcf.v3_1.cfint.cfint.buff.*;
import server.markhome.mcf.v3_1.cfsec.cfsecram.*;
import server.markhome.mcf.v3_1.cfint.cfintram.*;
import server.markhome.mcf.v3_1.cfbam.cfbam.*;
import server.markhome.mcf.v3_1.cfbam.cfbam.buff.*;
import server.markhome.mcf.v3_1.cfbam.cfbamram.*;

@Service("RamTestCFBam")
public class CFBamRamTestTestSchema {
    
    public String performTests(EntityManager em) {
		StringBuffer messages = new StringBuffer("Starting CFBam tests...\n");
		ICFBamScope[] scopeResults = ICFBamSchema.getBackingCFBam().getTableScope().readAllDerived(null);
		if (scopeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getScopeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + scopeResults.length + " entities from CFBam.Scope\n");
		}

		ICFBamSchemaDef[] schemaDefResults = ICFBamSchema.getBackingCFBam().getTableSchemaDef().readAllDerived(null);
		if (schemaDefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getSchemaDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + schemaDefResults.length + " entities from CFBam.SchemaDef\n");
		}

		ICFBamSchemaRef[] schemaRefResults = ICFBamSchema.getBackingCFBam().getTableSchemaRef().readAllDerived(null);
		if (schemaRefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getSchemaRefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + schemaRefResults.length + " entities from CFBam.SchemaRef\n");
		}

		ICFBamServerMethod[] serverMethodResults = ICFBamSchema.getBackingCFBam().getTableServerMethod().readAllDerived(null);
		if (serverMethodResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getServerMethodTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + serverMethodResults.length + " entities from CFBam.ServerMethod\n");
		}

		ICFBamServerObjFunc[] serverObjFuncResults = ICFBamSchema.getBackingCFBam().getTableServerObjFunc().readAllDerived(null);
		if (serverObjFuncResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getServerObjFuncTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + serverObjFuncResults.length + " entities from CFBam.ServerObjFunc\n");
		}

		ICFBamServerProc[] serverProcResults = ICFBamSchema.getBackingCFBam().getTableServerProc().readAllDerived(null);
		if (serverProcResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getServerProcTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + serverProcResults.length + " entities from CFBam.ServerProc\n");
		}

		ICFBamTable[] tableResults = ICFBamSchema.getBackingCFBam().getTableTable().readAllDerived(null);
		if (tableResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getTableTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tableResults.length + " entities from CFBam.Table\n");
		}

		ICFBamValue[] valueResults = ICFBamSchema.getBackingCFBam().getTableValue().readAllDerived(null);
		if (valueResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getValueTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + valueResults.length + " entities from CFBam.Value\n");
		}

		ICFBamAtom[] atomResults = ICFBamSchema.getBackingCFBam().getTableAtom().readAllDerived(null);
		if (atomResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getAtomTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + atomResults.length + " entities from CFBam.Atom\n");
		}

		ICFBamBlobDef[] blobDefResults = ICFBamSchema.getBackingCFBam().getTableBlobDef().readAllDerived(null);
		if (blobDefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getBlobDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + blobDefResults.length + " entities from CFBam.BlobDef\n");
		}

		ICFBamBlobType[] blobTypeResults = ICFBamSchema.getBackingCFBam().getTableBlobType().readAllDerived(null);
		if (blobTypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getBlobTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + blobTypeResults.length + " entities from CFBam.BlobType\n");
		}

		ICFBamBoolDef[] boolDefResults = ICFBamSchema.getBackingCFBam().getTableBoolDef().readAllDerived(null);
		if (boolDefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getBoolDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + boolDefResults.length + " entities from CFBam.BoolDef\n");
		}

		ICFBamBoolType[] boolTypeResults = ICFBamSchema.getBackingCFBam().getTableBoolType().readAllDerived(null);
		if (boolTypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getBoolTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + boolTypeResults.length + " entities from CFBam.BoolType\n");
		}

		ICFBamChain[] chainResults = ICFBamSchema.getBackingCFBam().getTableChain().readAllDerived(null);
		if (chainResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getChainTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + chainResults.length + " entities from CFBam.Chain\n");
		}

		ICFBamClearDep[] clearDepResults = ICFBamSchema.getBackingCFBam().getTableClearDep().readAllDerived(null);
		if (clearDepResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getClearDepTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + clearDepResults.length + " entities from CFBam.ClearDep\n");
		}

		ICFBamClearSubDep1[] clearSubDep1Results = ICFBamSchema.getBackingCFBam().getTableClearSubDep1().readAllDerived(null);
		if (clearSubDep1Results == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getClearSubDep1Table().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + clearSubDep1Results.length + " entities from CFBam.ClearSubDep1\n");
		}

		ICFBamClearSubDep2[] clearSubDep2Results = ICFBamSchema.getBackingCFBam().getTableClearSubDep2().readAllDerived(null);
		if (clearSubDep2Results == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getClearSubDep2Table().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + clearSubDep2Results.length + " entities from CFBam.ClearSubDep2\n");
		}

		ICFBamClearSubDep3[] clearSubDep3Results = ICFBamSchema.getBackingCFBam().getTableClearSubDep3().readAllDerived(null);
		if (clearSubDep3Results == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getClearSubDep3Table().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + clearSubDep3Results.length + " entities from CFBam.ClearSubDep3\n");
		}

		ICFBamClearTopDep[] clearTopDepResults = ICFBamSchema.getBackingCFBam().getTableClearTopDep().readAllDerived(null);
		if (clearTopDepResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getClearTopDepTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + clearTopDepResults.length + " entities from CFBam.ClearTopDep\n");
		}

		ICFBamDateDef[] dateDefResults = ICFBamSchema.getBackingCFBam().getTableDateDef().readAllDerived(null);
		if (dateDefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDateDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dateDefResults.length + " entities from CFBam.DateDef\n");
		}

		ICFBamDateType[] dateTypeResults = ICFBamSchema.getBackingCFBam().getTableDateType().readAllDerived(null);
		if (dateTypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDateTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dateTypeResults.length + " entities from CFBam.DateType\n");
		}

		ICFBamDelDep[] delDepResults = ICFBamSchema.getBackingCFBam().getTableDelDep().readAllDerived(null);
		if (delDepResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDelDepTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + delDepResults.length + " entities from CFBam.DelDep\n");
		}

		ICFBamDelSubDep1[] delSubDep1Results = ICFBamSchema.getBackingCFBam().getTableDelSubDep1().readAllDerived(null);
		if (delSubDep1Results == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDelSubDep1Table().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + delSubDep1Results.length + " entities from CFBam.DelSubDep1\n");
		}

		ICFBamDelSubDep2[] delSubDep2Results = ICFBamSchema.getBackingCFBam().getTableDelSubDep2().readAllDerived(null);
		if (delSubDep2Results == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDelSubDep2Table().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + delSubDep2Results.length + " entities from CFBam.DelSubDep2\n");
		}

		ICFBamDelSubDep3[] delSubDep3Results = ICFBamSchema.getBackingCFBam().getTableDelSubDep3().readAllDerived(null);
		if (delSubDep3Results == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDelSubDep3Table().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + delSubDep3Results.length + " entities from CFBam.DelSubDep3\n");
		}

		ICFBamDelTopDep[] delTopDepResults = ICFBamSchema.getBackingCFBam().getTableDelTopDep().readAllDerived(null);
		if (delTopDepResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDelTopDepTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + delTopDepResults.length + " entities from CFBam.DelTopDep\n");
		}

		ICFBamDoubleDef[] doubleDefResults = ICFBamSchema.getBackingCFBam().getTableDoubleDef().readAllDerived(null);
		if (doubleDefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDoubleDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + doubleDefResults.length + " entities from CFBam.DoubleDef\n");
		}

		ICFBamDoubleType[] doubleTypeResults = ICFBamSchema.getBackingCFBam().getTableDoubleType().readAllDerived(null);
		if (doubleTypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDoubleTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + doubleTypeResults.length + " entities from CFBam.DoubleType\n");
		}

		ICFBamEnumTag[] enumTagResults = ICFBamSchema.getBackingCFBam().getTableEnumTag().readAllDerived(null);
		if (enumTagResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getEnumTagTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + enumTagResults.length + " entities from CFBam.EnumTag\n");
		}

		ICFBamFloatDef[] floatDefResults = ICFBamSchema.getBackingCFBam().getTableFloatDef().readAllDerived(null);
		if (floatDefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getFloatDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + floatDefResults.length + " entities from CFBam.FloatDef\n");
		}

		ICFBamFloatType[] floatTypeResults = ICFBamSchema.getBackingCFBam().getTableFloatType().readAllDerived(null);
		if (floatTypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getFloatTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + floatTypeResults.length + " entities from CFBam.FloatType\n");
		}

		ICFBamIndex[] indexResults = ICFBamSchema.getBackingCFBam().getTableIndex().readAllDerived(null);
		if (indexResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getIndexTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + indexResults.length + " entities from CFBam.Index\n");
		}

		ICFBamIndexCol[] indexColResults = ICFBamSchema.getBackingCFBam().getTableIndexCol().readAllDerived(null);
		if (indexColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getIndexColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + indexColResults.length + " entities from CFBam.IndexCol\n");
		}

		ICFBamInt16Def[] int16DefResults = ICFBamSchema.getBackingCFBam().getTableInt16Def().readAllDerived(null);
		if (int16DefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getInt16DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + int16DefResults.length + " entities from CFBam.Int16Def\n");
		}

		ICFBamInt16Type[] int16TypeResults = ICFBamSchema.getBackingCFBam().getTableInt16Type().readAllDerived(null);
		if (int16TypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getInt16TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + int16TypeResults.length + " entities from CFBam.Int16Type\n");
		}

		ICFBamInt32Def[] int32DefResults = ICFBamSchema.getBackingCFBam().getTableInt32Def().readAllDerived(null);
		if (int32DefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getInt32DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + int32DefResults.length + " entities from CFBam.Int32Def\n");
		}

		ICFBamInt32Type[] int32TypeResults = ICFBamSchema.getBackingCFBam().getTableInt32Type().readAllDerived(null);
		if (int32TypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getInt32TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + int32TypeResults.length + " entities from CFBam.Int32Type\n");
		}

		ICFBamInt64Def[] int64DefResults = ICFBamSchema.getBackingCFBam().getTableInt64Def().readAllDerived(null);
		if (int64DefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getInt64DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + int64DefResults.length + " entities from CFBam.Int64Def\n");
		}

		ICFBamInt64Type[] int64TypeResults = ICFBamSchema.getBackingCFBam().getTableInt64Type().readAllDerived(null);
		if (int64TypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getInt64TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + int64TypeResults.length + " entities from CFBam.Int64Type\n");
		}

		ICFBamNmTokenDef[] nmTokenDefResults = ICFBamSchema.getBackingCFBam().getTableNmTokenDef().readAllDerived(null);
		if (nmTokenDefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getNmTokenDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + nmTokenDefResults.length + " entities from CFBam.NmTokenDef\n");
		}

		ICFBamNmTokenType[] nmTokenTypeResults = ICFBamSchema.getBackingCFBam().getTableNmTokenType().readAllDerived(null);
		if (nmTokenTypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getNmTokenTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + nmTokenTypeResults.length + " entities from CFBam.NmTokenType\n");
		}

		ICFBamNmTokensDef[] nmTokensDefResults = ICFBamSchema.getBackingCFBam().getTableNmTokensDef().readAllDerived(null);
		if (nmTokensDefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getNmTokensDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + nmTokensDefResults.length + " entities from CFBam.NmTokensDef\n");
		}

		ICFBamNmTokensType[] nmTokensTypeResults = ICFBamSchema.getBackingCFBam().getTableNmTokensType().readAllDerived(null);
		if (nmTokensTypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getNmTokensTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + nmTokensTypeResults.length + " entities from CFBam.NmTokensType\n");
		}

		ICFBamNumberDef[] numberDefResults = ICFBamSchema.getBackingCFBam().getTableNumberDef().readAllDerived(null);
		if (numberDefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getNumberDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + numberDefResults.length + " entities from CFBam.NumberDef\n");
		}

		ICFBamNumberType[] numberTypeResults = ICFBamSchema.getBackingCFBam().getTableNumberType().readAllDerived(null);
		if (numberTypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getNumberTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + numberTypeResults.length + " entities from CFBam.NumberType\n");
		}

		ICFBamParam[] paramResults = ICFBamSchema.getBackingCFBam().getTableParam().readAllDerived(null);
		if (paramResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getParamTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + paramResults.length + " entities from CFBam.Param\n");
		}

		ICFBamPopDep[] popDepResults = ICFBamSchema.getBackingCFBam().getTablePopDep().readAllDerived(null);
		if (popDepResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getPopDepTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + popDepResults.length + " entities from CFBam.PopDep\n");
		}

		ICFBamPopSubDep1[] popSubDep1Results = ICFBamSchema.getBackingCFBam().getTablePopSubDep1().readAllDerived(null);
		if (popSubDep1Results == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getPopSubDep1Table().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + popSubDep1Results.length + " entities from CFBam.PopSubDep1\n");
		}

		ICFBamPopSubDep2[] popSubDep2Results = ICFBamSchema.getBackingCFBam().getTablePopSubDep2().readAllDerived(null);
		if (popSubDep2Results == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getPopSubDep2Table().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + popSubDep2Results.length + " entities from CFBam.PopSubDep2\n");
		}

		ICFBamPopSubDep3[] popSubDep3Results = ICFBamSchema.getBackingCFBam().getTablePopSubDep3().readAllDerived(null);
		if (popSubDep3Results == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getPopSubDep3Table().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + popSubDep3Results.length + " entities from CFBam.PopSubDep3\n");
		}

		ICFBamPopTopDep[] popTopDepResults = ICFBamSchema.getBackingCFBam().getTablePopTopDep().readAllDerived(null);
		if (popTopDepResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getPopTopDepTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + popTopDepResults.length + " entities from CFBam.PopTopDep\n");
		}

		ICFBamRelation[] relationResults = ICFBamSchema.getBackingCFBam().getTableRelation().readAllDerived(null);
		if (relationResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getRelationTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + relationResults.length + " entities from CFBam.Relation\n");
		}

		ICFBamRelationCol[] relationColResults = ICFBamSchema.getBackingCFBam().getTableRelationCol().readAllDerived(null);
		if (relationColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getRelationColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + relationColResults.length + " entities from CFBam.RelationCol\n");
		}

		ICFBamServerListFunc[] serverListFuncResults = ICFBamSchema.getBackingCFBam().getTableServerListFunc().readAllDerived(null);
		if (serverListFuncResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getServerListFuncTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + serverListFuncResults.length + " entities from CFBam.ServerListFunc\n");
		}

		ICFBamDbKeyHash128Def[] dbKeyHash128DefResults = ICFBamSchema.getBackingCFBam().getTableDbKeyHash128Def().readAllDerived(null);
		if (dbKeyHash128DefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDbKeyHash128DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash128DefResults.length + " entities from CFBam.DbKeyHash128Def\n");
		}

		ICFBamDbKeyHash128Col[] dbKeyHash128ColResults = ICFBamSchema.getBackingCFBam().getTableDbKeyHash128Col().readAllDerived(null);
		if (dbKeyHash128ColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDbKeyHash128ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash128ColResults.length + " entities from CFBam.DbKeyHash128Col\n");
		}

		ICFBamDbKeyHash128Type[] dbKeyHash128TypeResults = ICFBamSchema.getBackingCFBam().getTableDbKeyHash128Type().readAllDerived(null);
		if (dbKeyHash128TypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDbKeyHash128TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash128TypeResults.length + " entities from CFBam.DbKeyHash128Type\n");
		}

		ICFBamDbKeyHash128Gen[] dbKeyHash128GenResults = ICFBamSchema.getBackingCFBam().getTableDbKeyHash128Gen().readAllDerived(null);
		if (dbKeyHash128GenResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDbKeyHash128GenTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash128GenResults.length + " entities from CFBam.DbKeyHash128Gen\n");
		}

		ICFBamDbKeyHash160Def[] dbKeyHash160DefResults = ICFBamSchema.getBackingCFBam().getTableDbKeyHash160Def().readAllDerived(null);
		if (dbKeyHash160DefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDbKeyHash160DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash160DefResults.length + " entities from CFBam.DbKeyHash160Def\n");
		}

		ICFBamDbKeyHash160Col[] dbKeyHash160ColResults = ICFBamSchema.getBackingCFBam().getTableDbKeyHash160Col().readAllDerived(null);
		if (dbKeyHash160ColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDbKeyHash160ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash160ColResults.length + " entities from CFBam.DbKeyHash160Col\n");
		}

		ICFBamDbKeyHash160Type[] dbKeyHash160TypeResults = ICFBamSchema.getBackingCFBam().getTableDbKeyHash160Type().readAllDerived(null);
		if (dbKeyHash160TypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDbKeyHash160TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash160TypeResults.length + " entities from CFBam.DbKeyHash160Type\n");
		}

		ICFBamDbKeyHash160Gen[] dbKeyHash160GenResults = ICFBamSchema.getBackingCFBam().getTableDbKeyHash160Gen().readAllDerived(null);
		if (dbKeyHash160GenResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDbKeyHash160GenTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash160GenResults.length + " entities from CFBam.DbKeyHash160Gen\n");
		}

		ICFBamDbKeyHash224Def[] dbKeyHash224DefResults = ICFBamSchema.getBackingCFBam().getTableDbKeyHash224Def().readAllDerived(null);
		if (dbKeyHash224DefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDbKeyHash224DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash224DefResults.length + " entities from CFBam.DbKeyHash224Def\n");
		}

		ICFBamDbKeyHash224Col[] dbKeyHash224ColResults = ICFBamSchema.getBackingCFBam().getTableDbKeyHash224Col().readAllDerived(null);
		if (dbKeyHash224ColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDbKeyHash224ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash224ColResults.length + " entities from CFBam.DbKeyHash224Col\n");
		}

		ICFBamDbKeyHash224Type[] dbKeyHash224TypeResults = ICFBamSchema.getBackingCFBam().getTableDbKeyHash224Type().readAllDerived(null);
		if (dbKeyHash224TypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDbKeyHash224TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash224TypeResults.length + " entities from CFBam.DbKeyHash224Type\n");
		}

		ICFBamDbKeyHash224Gen[] dbKeyHash224GenResults = ICFBamSchema.getBackingCFBam().getTableDbKeyHash224Gen().readAllDerived(null);
		if (dbKeyHash224GenResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDbKeyHash224GenTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash224GenResults.length + " entities from CFBam.DbKeyHash224Gen\n");
		}

		ICFBamDbKeyHash256Def[] dbKeyHash256DefResults = ICFBamSchema.getBackingCFBam().getTableDbKeyHash256Def().readAllDerived(null);
		if (dbKeyHash256DefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDbKeyHash256DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash256DefResults.length + " entities from CFBam.DbKeyHash256Def\n");
		}

		ICFBamDbKeyHash256Col[] dbKeyHash256ColResults = ICFBamSchema.getBackingCFBam().getTableDbKeyHash256Col().readAllDerived(null);
		if (dbKeyHash256ColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDbKeyHash256ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash256ColResults.length + " entities from CFBam.DbKeyHash256Col\n");
		}

		ICFBamDbKeyHash256Type[] dbKeyHash256TypeResults = ICFBamSchema.getBackingCFBam().getTableDbKeyHash256Type().readAllDerived(null);
		if (dbKeyHash256TypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDbKeyHash256TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash256TypeResults.length + " entities from CFBam.DbKeyHash256Type\n");
		}

		ICFBamDbKeyHash256Gen[] dbKeyHash256GenResults = ICFBamSchema.getBackingCFBam().getTableDbKeyHash256Gen().readAllDerived(null);
		if (dbKeyHash256GenResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDbKeyHash256GenTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash256GenResults.length + " entities from CFBam.DbKeyHash256Gen\n");
		}

		ICFBamDbKeyHash384Def[] dbKeyHash384DefResults = ICFBamSchema.getBackingCFBam().getTableDbKeyHash384Def().readAllDerived(null);
		if (dbKeyHash384DefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDbKeyHash384DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash384DefResults.length + " entities from CFBam.DbKeyHash384Def\n");
		}

		ICFBamDbKeyHash384Col[] dbKeyHash384ColResults = ICFBamSchema.getBackingCFBam().getTableDbKeyHash384Col().readAllDerived(null);
		if (dbKeyHash384ColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDbKeyHash384ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash384ColResults.length + " entities from CFBam.DbKeyHash384Col\n");
		}

		ICFBamDbKeyHash384Type[] dbKeyHash384TypeResults = ICFBamSchema.getBackingCFBam().getTableDbKeyHash384Type().readAllDerived(null);
		if (dbKeyHash384TypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDbKeyHash384TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash384TypeResults.length + " entities from CFBam.DbKeyHash384Type\n");
		}

		ICFBamDbKeyHash384Gen[] dbKeyHash384GenResults = ICFBamSchema.getBackingCFBam().getTableDbKeyHash384Gen().readAllDerived(null);
		if (dbKeyHash384GenResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDbKeyHash384GenTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash384GenResults.length + " entities from CFBam.DbKeyHash384Gen\n");
		}

		ICFBamDbKeyHash512Def[] dbKeyHash512DefResults = ICFBamSchema.getBackingCFBam().getTableDbKeyHash512Def().readAllDerived(null);
		if (dbKeyHash512DefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDbKeyHash512DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash512DefResults.length + " entities from CFBam.DbKeyHash512Def\n");
		}

		ICFBamDbKeyHash512Col[] dbKeyHash512ColResults = ICFBamSchema.getBackingCFBam().getTableDbKeyHash512Col().readAllDerived(null);
		if (dbKeyHash512ColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDbKeyHash512ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash512ColResults.length + " entities from CFBam.DbKeyHash512Col\n");
		}

		ICFBamDbKeyHash512Type[] dbKeyHash512TypeResults = ICFBamSchema.getBackingCFBam().getTableDbKeyHash512Type().readAllDerived(null);
		if (dbKeyHash512TypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDbKeyHash512TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash512TypeResults.length + " entities from CFBam.DbKeyHash512Type\n");
		}

		ICFBamDbKeyHash512Gen[] dbKeyHash512GenResults = ICFBamSchema.getBackingCFBam().getTableDbKeyHash512Gen().readAllDerived(null);
		if (dbKeyHash512GenResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDbKeyHash512GenTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dbKeyHash512GenResults.length + " entities from CFBam.DbKeyHash512Gen\n");
		}

		ICFBamStringDef[] stringDefResults = ICFBamSchema.getBackingCFBam().getTableStringDef().readAllDerived(null);
		if (stringDefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getStringDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + stringDefResults.length + " entities from CFBam.StringDef\n");
		}

		ICFBamStringType[] stringTypeResults = ICFBamSchema.getBackingCFBam().getTableStringType().readAllDerived(null);
		if (stringTypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getStringTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + stringTypeResults.length + " entities from CFBam.StringType\n");
		}

		ICFBamTZDateDef[] tZDateDefResults = ICFBamSchema.getBackingCFBam().getTableTZDateDef().readAllDerived(null);
		if (tZDateDefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getTZDateDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tZDateDefResults.length + " entities from CFBam.TZDateDef\n");
		}

		ICFBamTZDateType[] tZDateTypeResults = ICFBamSchema.getBackingCFBam().getTableTZDateType().readAllDerived(null);
		if (tZDateTypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getTZDateTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tZDateTypeResults.length + " entities from CFBam.TZDateType\n");
		}

		ICFBamTZTimeDef[] tZTimeDefResults = ICFBamSchema.getBackingCFBam().getTableTZTimeDef().readAllDerived(null);
		if (tZTimeDefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getTZTimeDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tZTimeDefResults.length + " entities from CFBam.TZTimeDef\n");
		}

		ICFBamTZTimeType[] tZTimeTypeResults = ICFBamSchema.getBackingCFBam().getTableTZTimeType().readAllDerived(null);
		if (tZTimeTypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getTZTimeTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tZTimeTypeResults.length + " entities from CFBam.TZTimeType\n");
		}

		ICFBamTZTimestampDef[] tZTimestampDefResults = ICFBamSchema.getBackingCFBam().getTableTZTimestampDef().readAllDerived(null);
		if (tZTimestampDefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getTZTimestampDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tZTimestampDefResults.length + " entities from CFBam.TZTimestampDef\n");
		}

		ICFBamTZTimestampType[] tZTimestampTypeResults = ICFBamSchema.getBackingCFBam().getTableTZTimestampType().readAllDerived(null);
		if (tZTimestampTypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getTZTimestampTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tZTimestampTypeResults.length + " entities from CFBam.TZTimestampType\n");
		}

		ICFBamTableCol[] tableColResults = ICFBamSchema.getBackingCFBam().getTableTableCol().readAllDerived(null);
		if (tableColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getTableColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tableColResults.length + " entities from CFBam.TableCol\n");
		}

		ICFBamTextDef[] textDefResults = ICFBamSchema.getBackingCFBam().getTableTextDef().readAllDerived(null);
		if (textDefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getTextDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + textDefResults.length + " entities from CFBam.TextDef\n");
		}

		ICFBamTextType[] textTypeResults = ICFBamSchema.getBackingCFBam().getTableTextType().readAllDerived(null);
		if (textTypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getTextTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + textTypeResults.length + " entities from CFBam.TextType\n");
		}

		ICFBamTimeDef[] timeDefResults = ICFBamSchema.getBackingCFBam().getTableTimeDef().readAllDerived(null);
		if (timeDefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getTimeDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + timeDefResults.length + " entities from CFBam.TimeDef\n");
		}

		ICFBamTimeType[] timeTypeResults = ICFBamSchema.getBackingCFBam().getTableTimeType().readAllDerived(null);
		if (timeTypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getTimeTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + timeTypeResults.length + " entities from CFBam.TimeType\n");
		}

		ICFBamTimestampDef[] timestampDefResults = ICFBamSchema.getBackingCFBam().getTableTimestampDef().readAllDerived(null);
		if (timestampDefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getTimestampDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + timestampDefResults.length + " entities from CFBam.TimestampDef\n");
		}

		ICFBamTimestampType[] timestampTypeResults = ICFBamSchema.getBackingCFBam().getTableTimestampType().readAllDerived(null);
		if (timestampTypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getTimestampTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + timestampTypeResults.length + " entities from CFBam.TimestampType\n");
		}

		ICFBamTokenDef[] tokenDefResults = ICFBamSchema.getBackingCFBam().getTableTokenDef().readAllDerived(null);
		if (tokenDefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getTokenDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tokenDefResults.length + " entities from CFBam.TokenDef\n");
		}

		ICFBamTokenType[] tokenTypeResults = ICFBamSchema.getBackingCFBam().getTableTokenType().readAllDerived(null);
		if (tokenTypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getTokenTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tokenTypeResults.length + " entities from CFBam.TokenType\n");
		}

		ICFBamUInt16Def[] uInt16DefResults = ICFBamSchema.getBackingCFBam().getTableUInt16Def().readAllDerived(null);
		if (uInt16DefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getUInt16DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uInt16DefResults.length + " entities from CFBam.UInt16Def\n");
		}

		ICFBamUInt16Type[] uInt16TypeResults = ICFBamSchema.getBackingCFBam().getTableUInt16Type().readAllDerived(null);
		if (uInt16TypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getUInt16TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uInt16TypeResults.length + " entities from CFBam.UInt16Type\n");
		}

		ICFBamUInt32Def[] uInt32DefResults = ICFBamSchema.getBackingCFBam().getTableUInt32Def().readAllDerived(null);
		if (uInt32DefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getUInt32DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uInt32DefResults.length + " entities from CFBam.UInt32Def\n");
		}

		ICFBamUInt32Type[] uInt32TypeResults = ICFBamSchema.getBackingCFBam().getTableUInt32Type().readAllDerived(null);
		if (uInt32TypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getUInt32TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uInt32TypeResults.length + " entities from CFBam.UInt32Type\n");
		}

		ICFBamUInt64Def[] uInt64DefResults = ICFBamSchema.getBackingCFBam().getTableUInt64Def().readAllDerived(null);
		if (uInt64DefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getUInt64DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uInt64DefResults.length + " entities from CFBam.UInt64Def\n");
		}

		ICFBamUInt64Type[] uInt64TypeResults = ICFBamSchema.getBackingCFBam().getTableUInt64Type().readAllDerived(null);
		if (uInt64TypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getUInt64TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uInt64TypeResults.length + " entities from CFBam.UInt64Type\n");
		}

		ICFBamUuidDef[] uuidDefResults = ICFBamSchema.getBackingCFBam().getTableUuidDef().readAllDerived(null);
		if (uuidDefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getUuidDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uuidDefResults.length + " entities from CFBam.UuidDef\n");
		}

		ICFBamUuid6Def[] uuid6DefResults = ICFBamSchema.getBackingCFBam().getTableUuid6Def().readAllDerived(null);
		if (uuid6DefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getUuid6DefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uuid6DefResults.length + " entities from CFBam.Uuid6Def\n");
		}

		ICFBamUuidType[] uuidTypeResults = ICFBamSchema.getBackingCFBam().getTableUuidType().readAllDerived(null);
		if (uuidTypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getUuidTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uuidTypeResults.length + " entities from CFBam.UuidType\n");
		}

		ICFBamUuid6Type[] uuid6TypeResults = ICFBamSchema.getBackingCFBam().getTableUuid6Type().readAllDerived(null);
		if (uuid6TypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getUuid6TypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uuid6TypeResults.length + " entities from CFBam.Uuid6Type\n");
		}

		ICFBamBlobCol[] blobColResults = ICFBamSchema.getBackingCFBam().getTableBlobCol().readAllDerived(null);
		if (blobColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getBlobColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + blobColResults.length + " entities from CFBam.BlobCol\n");
		}

		ICFBamBoolCol[] boolColResults = ICFBamSchema.getBackingCFBam().getTableBoolCol().readAllDerived(null);
		if (boolColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getBoolColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + boolColResults.length + " entities from CFBam.BoolCol\n");
		}

		ICFBamDateCol[] dateColResults = ICFBamSchema.getBackingCFBam().getTableDateCol().readAllDerived(null);
		if (dateColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDateColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + dateColResults.length + " entities from CFBam.DateCol\n");
		}

		ICFBamDoubleCol[] doubleColResults = ICFBamSchema.getBackingCFBam().getTableDoubleCol().readAllDerived(null);
		if (doubleColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getDoubleColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + doubleColResults.length + " entities from CFBam.DoubleCol\n");
		}

		ICFBamEnumDef[] enumDefResults = ICFBamSchema.getBackingCFBam().getTableEnumDef().readAllDerived(null);
		if (enumDefResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getEnumDefTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + enumDefResults.length + " entities from CFBam.EnumDef\n");
		}

		ICFBamEnumType[] enumTypeResults = ICFBamSchema.getBackingCFBam().getTableEnumType().readAllDerived(null);
		if (enumTypeResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getEnumTypeTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + enumTypeResults.length + " entities from CFBam.EnumType\n");
		}

		ICFBamFloatCol[] floatColResults = ICFBamSchema.getBackingCFBam().getTableFloatCol().readAllDerived(null);
		if (floatColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getFloatColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + floatColResults.length + " entities from CFBam.FloatCol\n");
		}

		ICFBamId16Gen[] id16GenResults = ICFBamSchema.getBackingCFBam().getTableId16Gen().readAllDerived(null);
		if (id16GenResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getId16GenTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + id16GenResults.length + " entities from CFBam.Id16Gen\n");
		}

		ICFBamId32Gen[] id32GenResults = ICFBamSchema.getBackingCFBam().getTableId32Gen().readAllDerived(null);
		if (id32GenResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getId32GenTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + id32GenResults.length + " entities from CFBam.Id32Gen\n");
		}

		ICFBamId64Gen[] id64GenResults = ICFBamSchema.getBackingCFBam().getTableId64Gen().readAllDerived(null);
		if (id64GenResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getId64GenTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + id64GenResults.length + " entities from CFBam.Id64Gen\n");
		}

		ICFBamInt16Col[] int16ColResults = ICFBamSchema.getBackingCFBam().getTableInt16Col().readAllDerived(null);
		if (int16ColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getInt16ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + int16ColResults.length + " entities from CFBam.Int16Col\n");
		}

		ICFBamInt32Col[] int32ColResults = ICFBamSchema.getBackingCFBam().getTableInt32Col().readAllDerived(null);
		if (int32ColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getInt32ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + int32ColResults.length + " entities from CFBam.Int32Col\n");
		}

		ICFBamInt64Col[] int64ColResults = ICFBamSchema.getBackingCFBam().getTableInt64Col().readAllDerived(null);
		if (int64ColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getInt64ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + int64ColResults.length + " entities from CFBam.Int64Col\n");
		}

		ICFBamNmTokenCol[] nmTokenColResults = ICFBamSchema.getBackingCFBam().getTableNmTokenCol().readAllDerived(null);
		if (nmTokenColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getNmTokenColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + nmTokenColResults.length + " entities from CFBam.NmTokenCol\n");
		}

		ICFBamNmTokensCol[] nmTokensColResults = ICFBamSchema.getBackingCFBam().getTableNmTokensCol().readAllDerived(null);
		if (nmTokensColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getNmTokensColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + nmTokensColResults.length + " entities from CFBam.NmTokensCol\n");
		}

		ICFBamNumberCol[] numberColResults = ICFBamSchema.getBackingCFBam().getTableNumberCol().readAllDerived(null);
		if (numberColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getNumberColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + numberColResults.length + " entities from CFBam.NumberCol\n");
		}

		ICFBamStringCol[] stringColResults = ICFBamSchema.getBackingCFBam().getTableStringCol().readAllDerived(null);
		if (stringColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getStringColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + stringColResults.length + " entities from CFBam.StringCol\n");
		}

		ICFBamTZDateCol[] tZDateColResults = ICFBamSchema.getBackingCFBam().getTableTZDateCol().readAllDerived(null);
		if (tZDateColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getTZDateColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tZDateColResults.length + " entities from CFBam.TZDateCol\n");
		}

		ICFBamTZTimeCol[] tZTimeColResults = ICFBamSchema.getBackingCFBam().getTableTZTimeCol().readAllDerived(null);
		if (tZTimeColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getTZTimeColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tZTimeColResults.length + " entities from CFBam.TZTimeCol\n");
		}

		ICFBamTZTimestampCol[] tZTimestampColResults = ICFBamSchema.getBackingCFBam().getTableTZTimestampCol().readAllDerived(null);
		if (tZTimestampColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getTZTimestampColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tZTimestampColResults.length + " entities from CFBam.TZTimestampCol\n");
		}

		ICFBamTextCol[] textColResults = ICFBamSchema.getBackingCFBam().getTableTextCol().readAllDerived(null);
		if (textColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getTextColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + textColResults.length + " entities from CFBam.TextCol\n");
		}

		ICFBamTimeCol[] timeColResults = ICFBamSchema.getBackingCFBam().getTableTimeCol().readAllDerived(null);
		if (timeColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getTimeColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + timeColResults.length + " entities from CFBam.TimeCol\n");
		}

		ICFBamTimestampCol[] timestampColResults = ICFBamSchema.getBackingCFBam().getTableTimestampCol().readAllDerived(null);
		if (timestampColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getTimestampColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + timestampColResults.length + " entities from CFBam.TimestampCol\n");
		}

		ICFBamTokenCol[] tokenColResults = ICFBamSchema.getBackingCFBam().getTableTokenCol().readAllDerived(null);
		if (tokenColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getTokenColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + tokenColResults.length + " entities from CFBam.TokenCol\n");
		}

		ICFBamUInt16Col[] uInt16ColResults = ICFBamSchema.getBackingCFBam().getTableUInt16Col().readAllDerived(null);
		if (uInt16ColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getUInt16ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uInt16ColResults.length + " entities from CFBam.UInt16Col\n");
		}

		ICFBamUInt32Col[] uInt32ColResults = ICFBamSchema.getBackingCFBam().getTableUInt32Col().readAllDerived(null);
		if (uInt32ColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getUInt32ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uInt32ColResults.length + " entities from CFBam.UInt32Col\n");
		}

		ICFBamUInt64Col[] uInt64ColResults = ICFBamSchema.getBackingCFBam().getTableUInt64Col().readAllDerived(null);
		if (uInt64ColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getUInt64ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uInt64ColResults.length + " entities from CFBam.UInt64Col\n");
		}

		ICFBamUuidCol[] uuidColResults = ICFBamSchema.getBackingCFBam().getTableUuidCol().readAllDerived(null);
		if (uuidColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getUuidColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uuidColResults.length + " entities from CFBam.UuidCol\n");
		}

		ICFBamUuid6Col[] uuid6ColResults = ICFBamSchema.getBackingCFBam().getTableUuid6Col().readAllDerived(null);
		if (uuid6ColResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getUuid6ColTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uuid6ColResults.length + " entities from CFBam.Uuid6Col\n");
		}

		ICFBamUuidGen[] uuidGenResults = ICFBamSchema.getBackingCFBam().getTableUuidGen().readAllDerived(null);
		if (uuidGenResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getUuidGenTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uuidGenResults.length + " entities from CFBam.UuidGen\n");
		}

		ICFBamUuid6Gen[] uuid6GenResults = ICFBamSchema.getBackingCFBam().getTableUuid6Gen().readAllDerived(null);
		if (uuid6GenResults == null) {
			messages.append("Erroneously retrieved null for ICFBamSchema.getUuid6GenTable().readAllDerived(null)\n");
		}
		else {
			messages.append("Retrieved " + uuid6GenResults.length + " entities from CFBam.Uuid6Gen\n");
		}

		messages.append("CFBam tests complete\n");
		return( messages.toString() );
	}
}