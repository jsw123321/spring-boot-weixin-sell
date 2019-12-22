/**  
 * 
 * @Title:  Date2LongSerializer.java   
 * @Package com.amarsoft.springboot.utils.serializer   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: jiangshanwen
 * @date:   2019年12月21日 下午10:44:03   
 * @version V1.0 
 * @Copyright: 2019 www.amarsoft.com.   All rights reserved. 
 * 
 */  
package com.amarsoft.springboot.utils.serializer;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**   
 * @ClassName:  Date2LongSerializer   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: jiangshanwen
 * @date:   2019年12月21日 下午10:44:03     
 * @Copyright: 2019 www.amarsoft.com Inc. All rights reserved. 
 * 
 */
public class Date2LongSerializer extends JsonSerializer<Date>{

	/**  
	 * 
	 * @Title: serialize
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param date
	 * @param jsonGenerator
	 * @param serializerProvider
	 * @throws IOException
	 * @author jiangshanwen
	 * @date 2019年12月21日 下午10:46:23
	 * @throws 
	 *   @see com.fasterxml.jackson.databind.JsonSerializer#serialize(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)
	 */
	@Override
	public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
		jsonGenerator.writeNumber(date.getTime()/1000);
	}

}
