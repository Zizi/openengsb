/**

   Copyright 2009 OpenEngSB Division, Vienna University of Technology

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   
 */

package org.openengsb.scm.common.endpoints;

import javax.jbi.messaging.MessageExchange;
import javax.jbi.messaging.NormalizedMessage;

import org.openengsb.scm.common.ParameterNames;
import org.openengsb.scm.common.commands.Command;
import org.openengsb.scm.common.util.StringSerializer;


/**
 * The Endpoint to the blame-feature
 */
public class BlameEndpoint extends AbstractScmEndpoint {
    private static final String BEHAVIOR = "blaming file.";

    @Override
    protected void processInOutRequest(MessageExchange exchange, NormalizedMessage in, NormalizedMessage out)
            throws Exception {
        // get parameters
        String fileName = extractStringParameter(in, "./@" + ParameterNames.FILE);

        // log parameters
        if (getLog().isDebugEnabled()) {
            StringBuilder parameters = new StringBuilder();
            parameters.append("Parameters:\n");
            parameters.append("fileName=");
            parameters.append(fileName);

            getLog().debug(parameters.toString());
        }

        // validate them
        if (fileName == null) {
            throw new IllegalArgumentException("Missing " + ParameterNames.FILE);
        }

        // execute call
        // TODO pimpify
        Command<String> command = getCommandFactory().getBlameCommand(fileName, null);
        String result = command.execute();

        // xml-ify result and send it back
        out.setContent(StringSerializer.serialize(result));
        // getChannel ().send (exchange);
    }

    @Override
    protected String getEndpointBehaviour() {
        return BlameEndpoint.BEHAVIOR;
    }
}
