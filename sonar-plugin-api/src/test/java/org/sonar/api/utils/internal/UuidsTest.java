/*
 * SonarQube, open source software quality management tool.
 * Copyright (C) 2008-2014 SonarSource
 * mailto:contact AT sonarsource DOT com
 *
 * SonarQube is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * SonarQube is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.api.utils.internal;

import com.google.common.collect.Sets;
import org.junit.Test;
import org.sonar.test.TestUtils;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class UuidsTest {

  @Test
  public void create_unique() throws Exception {
    Set<String> all = Sets.newHashSet();
    for (int i = 0; i < 50; i++) {
      String uuid = Uuids.create();
      assertThat(uuid).isNotEmpty();
      all.add(uuid);
    }
    assertThat(all).hasSize(50);
  }

  @Test
  public void constructor_is_private() throws Exception {
    TestUtils.hasOnlyPrivateConstructors(Uuids.class);
  }
}
