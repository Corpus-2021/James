/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

package org.apache.james.task;

import java.util.Objects;
import java.util.UUID;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

public class TaskId {

    public static TaskId generateTaskId() {
        return fromUUID(UUID.randomUUID());
    }

    public static TaskId fromUUID(UUID uuid) {
        Preconditions.checkNotNull(uuid, "'uuid' should not be null");
        return new TaskId(uuid);
    }

    public static TaskId fromString(String uuid) {
        Preconditions.checkNotNull(uuid, "'uuid' should not be null");
        return fromUUID(UUID.fromString(uuid));
    }

    private final UUID value;

    public TaskId(UUID value) {
        this.value = value;
    }

    public UUID getValue() {
        return value;
    }

    public String asString() {
        return value.toString();
    }

    @Override
    public final boolean equals(Object o) {
        if (o instanceof TaskId) {
            TaskId taskId = (TaskId) o;

            return Objects.equals(this.value, taskId.value);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("value", value)
            .toString();
    }
}
