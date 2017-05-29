CREATE TABLE "RULES_PROFILES" (
  "ID" INTEGER NOT NULL GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1),
  "NAME" VARCHAR(100) NOT NULL,
  "LANGUAGE" VARCHAR(20),
  "ORGANIZATION_UUID" VARCHAR(40) NOT NULL,
  "KEE" VARCHAR(255) NOT NULL,
  "PARENT_KEE" VARCHAR(255),
  "RULES_UPDATED_AT" VARCHAR(100),
  "IS_DEFAULT" BOOLEAN NOT NULL DEFAULT FALSE,
  "CREATED_AT" TIMESTAMP,
  "UPDATED_AT" TIMESTAMP,
  "LAST_USED" BIGINT,
  "USER_UPDATED_AT" BIGINT,
  "IS_BUILT_IN" BOOLEAN NOT NULL
);
CREATE UNIQUE INDEX "UNIQ_QPROF_KEY" ON "RULES_PROFILES" ("KEE");

CREATE TABLE "QPROFILES" (
  "UUID" VARCHAR(40) NOT NULL PRIMARY KEY,
  "ORGANIZATION_UUID" VARCHAR(40) NOT NULL,
  "RULES_PROFILE_UUID" VARCHAR(40) NOT NULL,
  "PARENT_UUID" VARCHAR(40),
  "CREATED_AT" BIGINT NOT NULL,
  "UPDATED_AT" BIGINT NOT NULL
);
CREATE INDEX "QPROFILES_ORG_UUID" ON "QPROFILES" ("ORGANIZATION_UUID");
