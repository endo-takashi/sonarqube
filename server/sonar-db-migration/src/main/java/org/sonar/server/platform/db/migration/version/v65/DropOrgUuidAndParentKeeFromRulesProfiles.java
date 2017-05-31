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

package org.sonar.server.platform.db.migration.version.v65;

import java.sql.SQLException;
import org.sonar.db.Database;
import org.sonar.server.platform.db.migration.sql.DropColumnsBuilder;
import org.sonar.server.platform.db.migration.step.DdlChange;

public class DropOrgUuidAndParentKeeFromRulesProfiles extends DdlChange {

  private static final String TABLE_NAME = "rules_profiles";
  private static final String COLUMN_NAME1 = "organization_uuid";
  private static final String COLUMN_NAME2 = "parent_kee";

  public DropOrgUuidAndParentKeeFromRulesProfiles(Database db) {
    super(db);
  }

  @Override
  public void execute(Context context) throws SQLException {
    context.execute(new DropColumnsBuilder(getDialect(), TABLE_NAME, COLUMN_NAME1).build());
    context.execute(new DropColumnsBuilder(getDialect(), TABLE_NAME, COLUMN_NAME2).build());
  }
}
