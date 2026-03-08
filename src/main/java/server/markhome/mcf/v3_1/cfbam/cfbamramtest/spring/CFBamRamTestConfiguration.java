
// Description: Java 25 Configuration of the RamTest application

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

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import server.markhome.mcf.v3_1.cfbam.cfbamramtest.CFBamRamTest;

@Configuration
public class CFBamRamTestConfiguration {
	
	@Bean(name = "appApplicationProperties")
	public Properties appApplicationProperties() {
		return( CFBamRamTest.getApplicationProperties() );
	}
	
	@Bean(name = "appSystemProperties")
	public Properties appSystemProperties() {
		return( CFBamRamTest.getSystemProperties() );
	}

	@Bean(name = "appUserDefaultProperties")
	public Properties appUserDefaultProperties() {
		return( CFBamRamTest.getUserDefaultProperties() );
	}
	
	@Bean(name = "appUserProperties")
	public Properties appUserProperties() {
		return( CFBamRamTest.getUserProperties() );
	}
	
	@Bean(name = "appMergedProperties")
	public Properties appMergedProperties() {
		return( CFBamRamTest.getMergedProperties() );
	}
}
