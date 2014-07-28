/*
 * Copyright 2014 CyberVision, Inc.
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

package org.kaaproject.kaa.client.channel;

import java.util.List;

import org.kaaproject.kaa.common.TransportType;
import org.kaaproject.kaa.common.bootstrap.gen.ChannelType;

/**
 * Channel manager establishes/removes channels' links between client and
 * server.
 *
 * @author Yaroslav Zeygerman
 *
 */
public interface KaaChannelManager {

    /**
     * Updates the manager by adding the channel.
     *
     * @param channel
     *            channel to be added.
     * @see KaaDataChannel
     *
     */
    void addChannel(KaaDataChannel channel);

    /**
     * Updates the manager by removing the channel from the manager.
     *
     * @param channel channel to be removed.
     * @see KaaDataChannel
     *
     */
    void removeChannel(KaaDataChannel channel);

    /**
     * Retrieves the list of current channels.
     *
     * @return the channels' list.
     * @see KaaDataChannel
     *
     */
    List<KaaDataChannel> getChannels();

    /**
     * Retrieves the list of channels by the specific type (HTTP, HTTP_LP,
     * BOOTSTRAP and etc.).
     *
     * @param type type of the channel.
     * @return the channels' list.
     *
     * @see ChannelType
     * @see KaaDataChannel
     *
     */
    List<KaaDataChannel> getChannelsByType(ChannelType type);

    /**
     * Retrieves the list of channels by the specific transport type.
     *
     * @param type the transport's type.
     * @return the channels' list.
     *
     * @see TransportType
     * @see KaaDataChannel
     *
     */
    KaaDataChannel getChannelByTransportType(TransportType type);

    /**
     * Retrieves channel by the unique channel id.
     *
     * @param id the channel's id.
     * @return channel object.
     *
     * @see KaaDataChannel
     *
     */
    KaaDataChannel getChannel(String id);

    /**
     * Reports to Channel Manager in case link with server was not established.
     *
     * @param server the parameters of server that was not connected.
     * @see ServerInfo
     *
     */
    void onServerFailed(ServerInfo server);

    /**
     * Reports to Channel Manager about the new server.
     *
     * @param newServer the parameters of the new server.
     * @see ServerInfo
     *
     */
    void onServerUpdated(ServerInfo newServer);

    /**
     * Clears the list of channels.
     */
    void clearChannelList();
}