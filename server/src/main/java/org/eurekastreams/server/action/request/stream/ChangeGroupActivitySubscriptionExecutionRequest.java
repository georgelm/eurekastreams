/*
 * Copyright (c) 2010-2011 Lockheed Martin Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.eurekastreams.server.action.request.stream;

/**
 * Request for ChangeGroupActivitySubscriptionExecution.
 */
public class ChangeGroupActivitySubscriptionExecutionRequest
{
    /**
     * The short name of the group.
     */
    private String groupShortName;

    /**
     * Whether the user wants to receive new activity notifications.
     */
    private Boolean receiveNewActivityNotifications;

    /**
     * @return the groupShortName
     */
    public String getGroupShortName()
    {
        return groupShortName;
    }

    /**
     * @param inGroupShortName
     *            the groupShortName to set
     */
    public void setGroupShortName(final String inGroupShortName)
    {
        groupShortName = inGroupShortName;
    }

    /**
     * @return the receiveNewActivityNotifications
     */
    public Boolean getReceiveNewActivityNotifications()
    {
        return receiveNewActivityNotifications;
    }

    /**
     * @param inReceiveNewActivityNotifications
     *            the receiveNewActivityNotifications to set
     */
    public void setReceiveNewActivityNotifications(final Boolean inReceiveNewActivityNotifications)
    {
        receiveNewActivityNotifications = inReceiveNewActivityNotifications;
    }

}
