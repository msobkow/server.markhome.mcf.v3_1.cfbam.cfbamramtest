
// Description: Spring StartupListener for the RamTest program

/*
 *	io.github.msobkow.CFBam
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

package io.github.msobkow.v3_1.cfbam.cfbamramtest.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import io.github.msobkow.v3_1.cflib.*;
import io.github.msobkow.v3_1.cflib.dbutil.*;
import io.github.msobkow.v3_1.cfsec.cfsec.*;
import io.github.msobkow.v3_1.cfint.cfint.*;
import io.github.msobkow.v3_1.cfbam.cfbam.*;
import io.github.msobkow.v3_1.cfsec.cfsec.buff.*;
import io.github.msobkow.v3_1.cfint.cfint.buff.*;
import io.github.msobkow.v3_1.cfbam.cfbam.buff.*;
import io.github.msobkow.v3_1.cfsec.cfsecram.*;
import io.github.msobkow.v3_1.cfint.cfintram.*;
import io.github.msobkow.v3_1.cfbam.cfbamram.*;

@Component
public class CFBamRamTestStartupListener {
    @Autowired
    // @Qualifier("TestCFSec")
    private CFSecRamTestTestSchema testCFSec;

    @Autowired
    // @Qualifier("TestCFInt")
    private CFIntRamTestTestSchema testCFInt;

    @Autowired
    // @Qualifier("TestCFBam")
    private CFBamRamTestTestSchema testCFBam;

    @EventListener
    public void onApplicationReady(ApplicationReadyEvent event) {
        System.err.println("CFBamRamTest StartupListener tests beginning...");

		ICFSecSchema.getBackingCFSec().wireTableTableInstances();
		ICFIntSchema.getBackingCFInt().wireTableTableInstances();
		ICFBamSchema.getBackingCFBam().wireTableTableInstances();

		ICFSecSchema.getBackingCFSec().bootstrapSchema();
		ICFIntSchema.getBackingCFInt().bootstrapSchema();
		ICFBamSchema.getBackingCFBam().bootstrapSchema();

        System.err.println("Executing testCFSec.performTests()");
        try {
            String response = testCFSec.performTests(null);
            if (response != null) {
                System.err.println("CFSecRamTestTestSchema.performTests() responded: " + response);
            }
            else {
                System.err.println("CFSecRamTestTestSchema.performTests() did not return a response");
            }
        }
        catch (Throwable th) {
            System.err.println("testCFSec.performTests() threw " + th.getClass().getCanonicalName() + " - " + th.getMessage());
            th.printStackTrace(System.err);
        }

        System.err.println("Executing testCFInt.performTests()");
        try {
            String response = testCFInt.performTests(null);
            if (response != null) {
                System.err.println("CFIntRamTestTestSchema.performTests() responded: " + response);
            }
            else {
                System.err.println("CFIntRamTestTestSchema.performTests() did not return a response");
            }
        }
        catch (Throwable th) {
            System.err.println("testCFInt.performTests() threw " + th.getClass().getCanonicalName() + " - " + th.getMessage());
            th.printStackTrace(System.err);
        }

        System.err.println("Executing testCFBam.performTests()");
        try {
            String response = testCFBam.performTests(null);
            if (response != null) {
                System.err.println("CFBamRamTestTestSchema.performTests() responded: " + response);
            }
            else {
                System.err.println("CFBamRamTestTestSchema.performTests() did not return a response");
            }
        }
        catch (Throwable th) {
            System.err.println("testCFBam.performTests() threw " + th.getClass().getCanonicalName() + " - " + th.getMessage());
            th.printStackTrace(System.err);
        }

        System.err.println("CFBamRamTest StartupListener tests complete.");
    }
}
