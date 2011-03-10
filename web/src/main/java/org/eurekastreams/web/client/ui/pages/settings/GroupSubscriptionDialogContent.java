/*
 * Copyright (c) 2011 Lockheed Martin Corporation
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
package org.eurekastreams.web.client.ui.pages.settings;

import java.util.ArrayList;

import org.eurekastreams.server.action.request.profile.GetFollowersFollowingRequest;
import org.eurekastreams.server.domain.EntityType;
import org.eurekastreams.server.domain.PagedSet;
import org.eurekastreams.server.search.modelview.DomainGroupModelView;
import org.eurekastreams.web.client.events.EventBus;
import org.eurekastreams.web.client.events.Observer;
import org.eurekastreams.web.client.events.data.GotPersonJoinedGroupsResponseEvent;
import org.eurekastreams.web.client.model.PersonJoinedGroupsModel;
import org.eurekastreams.web.client.ui.Session;
import org.eurekastreams.web.client.ui.common.GroupPanel;
import org.eurekastreams.web.client.ui.common.dialog.BaseDialogContent;
import org.eurekastreams.web.client.ui.pages.master.StaticResourceBundle;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * Displays the list of groups a user has joined and allows the user to elect whether to receive notifications for them.
 */
public class GroupSubscriptionDialogContent extends BaseDialogContent
{
    /** The main content panel. */
    private FlowPanel mainPanel;

    /** List of gropus user is a member of. */
    private PagedSet<DomainGroupModelView> groups;

    /** IDs of groups for which user chose to subscribe to notifications. */
    private ArrayList<Long> subscribedGroupIds;

    /**
     * {@inheritDoc}
     */
    public String getTitle()
    {
        return "Groups you have joined";
    }

    /**
     * {@inheritDoc}
     */
    public Widget getBody()
    {
        if (mainPanel == null)
        {
            mainPanel = new FlowPanel();
            mainPanel.addStyleName(StaticResourceBundle.INSTANCE.coreCss().groupNotifSubscriptionPanel());
        }
        return mainPanel;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void show()
    {
        final EventBus eventBus = Session.getInstance().getEventBus();
        if (groups == null)
        {
            eventBus.addObserver(GotPersonJoinedGroupsResponseEvent.class,
                    new Observer<GotPersonJoinedGroupsResponseEvent>()
                    {
                        public void update(final GotPersonJoinedGroupsResponseEvent event)
                        {
                            eventBus.removeObserver(event, this);
                            groups = event.getResponse();
                            if (subscribedGroupIds != null)
                            {
                                populate();
                            }
                        }
                    });
            PersonJoinedGroupsModel.getInstance().fetch(
                    new GetFollowersFollowingRequest(EntityType.GROUP, Session.getInstance().getCurrentPerson()
                            .getAccountId(), 0, Integer.MAX_VALUE), true);
        }
        if (subscribedGroupIds == null)
        {
            // TODO
            subscribedGroupIds = new ArrayList<Long>();
            if (groups != null)
            {
                populate();
            }
        }
    }

    /**
     * Builds the content from the two lists.
     */
    private void populate()
    {
        for (DomainGroupModelView group : groups.getPagedSet())
        {
            GroupPanel groupWidget = new GroupPanel(group, true, true, false);

            final Label subscribeButton = new Label();
            final Label unsubscribeButton = new Label();

            subscribeButton.addStyleName(StaticResourceBundle.INSTANCE.coreCss().groupNotifSubscribeButton());
            unsubscribeButton.addStyleName(StaticResourceBundle.INSTANCE.coreCss().groupNotifUnsubscribeButton());

            subscribeButton.addClickHandler(new ClickHandler()
            {
                public void onClick(final ClickEvent inArg0)
                {
                    subscribeButton.setVisible(false);
                    unsubscribeButton.setVisible(true);
                    // TODO Auto-generated method stub
                }
            });
            unsubscribeButton.addClickHandler(new ClickHandler()
            {
                public void onClick(final ClickEvent inArg0)
                {
                    unsubscribeButton.setVisible(false);
                    subscribeButton.setVisible(true);
                    // TODO Auto-generated method stub
                }
            });

            boolean subscribed = subscribedGroupIds.contains(group.getId());
            subscribeButton.setVisible(!subscribed);
            unsubscribeButton.setVisible(subscribed);

            groupWidget.add(subscribeButton);
            groupWidget.add(unsubscribeButton);

            mainPanel.add(groupWidget);
        }
    }

    /**
     * {@inheritDoc}
     */
    public String getCssName()
    {
        // TODO Auto-generated method stub
        return null;
    }
}
