/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.azurecompute.arm.domain;

import java.util.Map;

import org.jclouds.javax.annotation.Nullable;
import org.jclouds.json.SerializedNames;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableMap;

/**
 * A secret bundle from key vault.
 */
@AutoValue
public abstract class SecretBundle {
    /**
     * The id of the secret
     */
   public abstract String id();

    /**
     * The value of the secret
     */
   public abstract String value();

    /**
     * The content type of the secret
     */
   public abstract String contentType();

   /**
    * Specifies the tags of the secret
    */
   @Nullable
   public abstract Map<String, String> tags();

    /**
     * Key backing KV certificate (if applicable)
     */
   @Nullable
   public abstract String kid();

    /**
     * The managed state of the secret
     */
   public abstract Boolean managed();

   @SerializedNames({"id", "value", "contentType", "tags", "kid", "managed"})
    public static SecretBundle create(final String id, final String value, final String contentType, @Nullable final Map<String, String> tags, @Nullable final String kid, final Boolean managed) {
       return builder().id(id).value(value).contentType(contentType).kid(kid).tags(tags).managed(managed)
               .build();
   }

   public abstract Builder toBuilder();

   public static Builder builder() { return new AutoValue_SecretBundle.Builder(); }


   @AutoValue.Builder
    public abstract  static class Builder {
       public abstract Builder id(String id);
       public abstract Builder value(String value);
       public abstract Builder contentType(String contentType);
       public abstract Builder tags(Map<String, String> tags);
       public abstract Builder kid(String kid);
       public abstract Builder managed(Boolean managed);

       abstract Map<String, String> tags();

       abstract SecretBundle autoBuild();

       public SecretBundle build() {
           tags(tags() != null ? ImmutableMap.copyOf(tags()) : null);
           return autoBuild();
       }
   }
}
