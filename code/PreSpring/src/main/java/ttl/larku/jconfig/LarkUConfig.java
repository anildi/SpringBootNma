/*
Copyright 2019-2022 Anil Pal
All rights reserved by The Third Lane, LLC.
*/

package ttl.larku.jconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"ttl.larku.service", "ttl.larku.dao", "ttl.larku.misc"})
@PropertySource({"classpath:/larkUContext.properties"})
public class LarkUConfig {
}