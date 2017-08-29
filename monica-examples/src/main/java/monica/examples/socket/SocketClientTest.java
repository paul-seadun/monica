/*
 * Copyright 2017 The Monica Project
 *
 * The Monica Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package monica.examples.socket;

import monica.container.client.ClientContainer;

/**
 * 
 * @author lucy@polarcoral.com
 *
 * 2017-08-29
 */
public class SocketClientTest {
	
	public static void main(String args[]){
		 ClientContainer clientContainer = new ClientContainer();
		 try{
			 clientContainer.start();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 
	}
   
    
}