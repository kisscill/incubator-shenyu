/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dromara.soul.admin.config;

import org.dromara.soul.register.common.config.SoulRegisterCenterConfig;
import org.dromara.soul.register.server.consul.SoulConsulConfigWatch;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "soul.register", name = "registerType", havingValue = "consul")
public class ConsulServerConfiguration {
    
    /**
     * Register soulConsulConfigWatch for ConsulServerRegisterRepository to monitor metadata.
     *
     * @param config the soul register center config
     * @param publisher the application event publisher
     * @return the consul config watch
     */
    @Bean
    public SoulConsulConfigWatch soulConsulConfigWatch(final SoulRegisterCenterConfig config, final ApplicationEventPublisher publisher) {
        return new SoulConsulConfigWatch(config, publisher);
    }
}