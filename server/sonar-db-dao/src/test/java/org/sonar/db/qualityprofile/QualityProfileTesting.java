/*
 * SonarQube
 * Copyright (C) 2009-2017 SonarSource SA
 * mailto:info AT sonarsource DOT com
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
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.db.qualityprofile;

import org.sonar.core.util.Uuids;

import static org.apache.commons.lang.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang.math.RandomUtils.nextLong;

public class QualityProfileTesting {

  private QualityProfileTesting() {
    // prevent instantiation
  }

  /**
   * Create an instance of {@link  QProfileDto} with random field values.
   */
  public static QProfileDto newQualityProfileDto() {
    String uuid = Uuids.createFast();
    return QProfileDto.createFor(uuid)
      .setOrganizationUuid(randomAlphanumeric(40))
      .setName(uuid)
      .setLanguage(randomAlphanumeric(20))
      .setLastUsed(nextLong());
  }

  /**
   * Create an instance of {@link  QProfileChangeDto} with random field values,
   * except changeType which is always {@code "ACTIVATED"}.
   */
  public static QProfileChangeDto newQProfileChangeDto() {
    return new QProfileChangeDto()
      .setKey(randomAlphanumeric(40))
      .setProfileKey(randomAlphanumeric(40))
      .setCreatedAt(nextLong())
      .setChangeType("ACTIVATED")
      .setLogin(randomAlphanumeric(10));
  }
}
