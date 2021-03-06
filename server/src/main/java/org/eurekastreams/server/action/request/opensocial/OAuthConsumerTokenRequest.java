/*
 * Copyright (c) 2010 Lockheed Martin Corporation
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
package org.eurekastreams.server.action.request.opensocial;

import java.io.Serializable;

import org.apache.shindig.auth.SecurityToken;
import org.apache.shindig.gadgets.oauth.OAuthStore.ConsumerInfo;

/**
 * Abstract parent request class containing parameters for oauth consumer requests involving tokens.
 */
public abstract class OAuthConsumerTokenRequest implements Serializable
{
    /**
     * Serialization id.
     */
    private static final long serialVersionUID = -5683014205045647860L;

    /**
     * Instance of the {@link SecurityToken} for this request.
     */
    private SecurityToken securityToken;

    /**
     * Instance of the {@link ConsumerInfo} for this request.
     */
    private ConsumerInfo consumerInfo;

    /**
     * Instance of the service name for this request.
     */
    private String serviceName;

    /**
     * Instance of the token name for this request.
     */
    private String tokenName;

    /**
     * Empty constructor for serialization.
     */
    protected OAuthConsumerTokenRequest()
    {
    }

    /**
     * Constructor.
     * 
     * @param inSecurityToken
     *            security token for this request.
     * @param inConsumerInfo
     *            consumer info for this request.
     * @param inServiceName
     *            service name for this request.
     * @param inTokenName
     *            token name for this request.
     */
    protected OAuthConsumerTokenRequest(final SecurityToken inSecurityToken, final ConsumerInfo inConsumerInfo,
            final String inServiceName, final String inTokenName)
    {
        setSecurityToken(inSecurityToken);
        setConsumerInfo(inConsumerInfo);
        setServiceName(inServiceName);
        setTokenName(inTokenName);
    }

    /**
     * @param inSecurityToken
     *            the securityToken to set
     */
    public void setSecurityToken(final SecurityToken inSecurityToken)
    {
        securityToken = inSecurityToken;
    }

    /**
     * @return the securityToken
     */
    public SecurityToken getSecurityToken()
    {
        return securityToken;
    }

    /**
     * @param inConsumerInfo
     *            the consumerInfo to set
     */
    public void setConsumerInfo(final ConsumerInfo inConsumerInfo)
    {
        consumerInfo = inConsumerInfo;
    }

    /**
     * @return the consumerInfo
     */
    public ConsumerInfo getConsumerInfo()
    {
        return consumerInfo;
    }

    /**
     * @param inServiceName
     *            the serviceName to set
     */
    public void setServiceName(final String inServiceName)
    {
        serviceName = inServiceName;
    }

    /**
     * @return the serviceName
     */
    public String getServiceName()
    {
        return serviceName;
    }

    /**
     * @param inTokenName
     *            the tokenName to set
     */
    public void setTokenName(final String inTokenName)
    {
        tokenName = inTokenName;
    }

    /**
     * @return the tokenName
     */
    public String getTokenName()
    {
        return tokenName;
    }
}
