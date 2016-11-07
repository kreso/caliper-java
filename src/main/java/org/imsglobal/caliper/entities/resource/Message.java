/**
 * This file is part of IMS Caliper Analytics™ and is licensed to
 * IMS Global Learning Consortium, Inc. (http://www.imsglobal.org)
 * under one or more contributor license agreements.  See the NOTICE
 * file distributed with this work for additional information.
 *
 * IMS Caliper is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, version 3 of the License.
 *
 * IMS Caliper is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.imsglobal.caliper.entities.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.imsglobal.caliper.entities.EntityType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class Message extends DigitalResource {

    @JsonProperty("@type")
    private final String type;

    @JsonProperty("body")
    private final String body;

    @JsonProperty("replyTo")
    private final Message replyTo;

    @JsonProperty("attachments")
    private final ImmutableList<Resource> attachments;

    /**
     * @param builder apply builder object properties to the CaliperAssessment object.
     */
    protected Message(Builder<?> builder) {
        super(builder);
        this.type = builder.type;
        this.body = builder.body;
        this.replyTo = builder.replyTo;
        this.attachments = ImmutableList.copyOf(builder.attachments);
    }

    /**
     * @return the type
     */
    @Override
    @Nonnull
    public String getType() {
        return type;
    }

    /**
     * @return textual body of the message
     */
    @Nullable
    public String getBody() {
        return body;
    }

    /**
     * @return message which prompted this message
    */
    @Nullable
    public Message getReplyTo() {
        return replyTo;
    }

    /**
     * @return attachments linked to this message
     */
    public ImmutableList<Resource> getAttachments() {
        return attachments;
    }

    /**
     * Builder class provides a fluid interface for setting object properties.
     * @param <T> builder
     */
    public static abstract class Builder<T extends Builder<T>> extends DigitalResource.Builder<T>  {
        private String type;
        private String body;
        private Message replyTo;
        private List<Resource> attachments = Lists.newArrayList();

        /**
         * Initialize type with default value.
         */
        public Builder() {
            type(EntityType.MESSAGE.getValue());
        }

        /**
         * @param type
         * @return builder.
         */
        private T type(String type) {
            this.type = type;
            return self();
        }

        /**
         * @param body
         * @return builder.
         */
        public T body(String body) {
            this.body = body;
            return self();
        }

        /**
         * @param replyTo
         * @return builder.
         */
        public T replyTo(Message replyTo) {
            this.replyTo = replyTo;
            return self();
        }

        /**
         * @param attachments
         * @return builder.
         */
        public T attachments(List<Resource> attachments) {
            this.attachments = attachments;
            return self();
        }

        /**
         * @param attachment
         * @return builder.
         */
        public T attachment(Resource attachment) {
            this.attachments.add(attachment);
            return self();
        }

        /**
         * Client invokes build method in order to create an immutable object.
         * @return a new Message instance.
         */
        public Message build() {
            return new Message(this);
        }
    }

    /**
     *
     */
    private static class Builder2 extends Builder<Builder2> {
        @Override
        protected Builder2 self() {
            return this;
        }
    }

    /**
     * Static factory method.
     * @return a new instance of the builder.
     */
    public static Builder<?> builder() {
        return new Builder2();
    }
}