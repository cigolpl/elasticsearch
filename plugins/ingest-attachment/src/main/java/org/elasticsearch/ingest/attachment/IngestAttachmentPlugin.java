/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.ingest.attachment;

import org.elasticsearch.node.NodeModule;
import org.elasticsearch.plugins.Plugin;

import java.io.IOException;

public class IngestAttachmentPlugin extends Plugin {

    @Override
    public String name() {
        return "ingest-attachment";
    }

    @Override
    public String description() {
        return "Ingest processor that adds uses Tika to extract binary data";
    }

    public void onModule(NodeModule nodeModule) throws IOException {
        nodeModule.registerProcessor(AttachmentProcessor.TYPE,
            (registry) -> new AttachmentProcessor.Factory());
    }
}
