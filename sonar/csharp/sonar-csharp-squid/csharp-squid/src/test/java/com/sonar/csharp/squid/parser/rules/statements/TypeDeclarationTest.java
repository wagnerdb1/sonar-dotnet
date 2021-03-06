/*
 * Sonar C# Plugin :: C# Squid :: Squid
 * Copyright (C) 2010 Jose Chillan, Alexandre Victoor and SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package com.sonar.csharp.squid.parser.rules.statements;

import com.sonar.csharp.squid.parser.CSharpGrammar;
import com.sonar.csharp.squid.parser.RuleTest;
import org.junit.Before;
import org.junit.Test;

import static org.sonar.sslr.tests.Assertions.assertThat;

public class TypeDeclarationTest extends RuleTest {

  @Before
  public void init() {
    p.setRootRule(p.getGrammar().rule(CSharpGrammar.TYPE_DECLARATION));
    p.getGrammar().rule(CSharpGrammar.CLASS_DECLARATION).override("classDeclaration");
    p.getGrammar().rule(CSharpGrammar.STRUCT_DECLARATION).override("structDeclaration");
    p.getGrammar().rule(CSharpGrammar.INTERFACE_DECLARATION).override("interfaceDeclaration");
    p.getGrammar().rule(CSharpGrammar.ENUM_DECLARATION).override("enumDeclaration");
    p.getGrammar().rule(CSharpGrammar.DELEGATE_DECLARATION).override("delegateDeclaration");
  }

  @Test
  public void ok() {
    assertThat(p)
        .matches("classDeclaration")
        .matches("structDeclaration")
        .matches("interfaceDeclaration")
        .matches("enumDeclaration")
        .matches("delegateDeclaration");
  }

}
