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
package org.openengsb.scm.common.exceptions;

/**
 * A standard implementations for a checked Exception to be used in
 * implementations of ScmDomain
 */
public class ScmException extends Exception {
    private static final long serialVersionUID = -2578454632707077795L;

    public ScmException() {
    }

    public ScmException(String message) {
        super(message);
    }

    public ScmException(Throwable cause) {
        super(cause);
    }

    public ScmException(String message, Throwable cause) {
        super(message, cause);
    }

}
