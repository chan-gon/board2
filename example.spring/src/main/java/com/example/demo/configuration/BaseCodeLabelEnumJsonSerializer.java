package com.example.demo.configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.example.demo.mvc.domain.BaseCodeLabelEnum;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * JSON ��ȯ�� BaseCodeLabelEnum Ŭ������ ���� ��ȯ�� �����ϰ� ó���Ѵ�.
 * @author ������
 *
 */
public class BaseCodeLabelEnumJsonSerializer extends JsonSerializer<BaseCodeLabelEnum>{

//	Map�� code, label ���� key-value �������� ��´�.
	@Override
	public void serialize(BaseCodeLabelEnum value, JsonGenerator jsonGenerator, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", value.code());
		map.put("label", value.label());
		jsonGenerator.writeObject(map);
	}

}
