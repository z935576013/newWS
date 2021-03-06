package com.merak.ws.client;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class UrlServiceTest {
//	public static void main(String[] args) {
//		cl2();
//	}

	public static void cl2() {
		String url = "https://www.merak.com/ws/services/ProposalResponseService?wsdl";
		 url =
		 "http://localhost:8002/ws/services/ProposalResponseService?wsdl";
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();

		Client client = dcf.createClient(url);
		client.getInInterceptors().add(new LoggingInInterceptor());
		client.getOutInterceptors().add(new LoggingOutInterceptor());

		Object[] objects = new Object[0];
		try {
			objects = client.invoke("SetProposalResponse", new Object[] { "fff", "bb" });

			System.out.println("结果:" + objects[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
