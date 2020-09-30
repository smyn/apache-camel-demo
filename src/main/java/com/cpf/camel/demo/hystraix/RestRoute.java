package com.cpf.camel.demo.hystraix;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.model.rest.*;

/**
 * @作者：caopengfei
 * @时间：2020/6/28
 */
public class RestRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().component("jetty").host("0.0.0.0").port(9999).bindingMode(RestBindingMode.auto);
        RouteDefinition rd = from("rest:post:ehr:/abc/def/{ddd}");
        String[] uris = new String[]{"http://172.16.0.29:8082"};
        formatterToUri(uris);
        rd.process(new FallbackProcessor()).toD(uris[0]);
    }

    public void formatterToUri(String[] uris) {
        Long timeOut = 30L;
        if (timeOut == null || timeOut.intValue() == 0) {
            timeOut = 300000L;
        }
        for (int i = 0; i < uris.length; i++) {
            String uri = uris[i];
            if (uri.startsWith("http")) {
                if (uri.contains("?")) {
                    uris[i] = uris[i] + "&";
                } else {
                    uris[i] = uris[i] + "?";
                }

                if (uri.startsWith("http://")) {
                    uris[i] = uris[i].replace("http://", "http4://");
                } else if (uri.startsWith("https://")) {
                    uris[i] = uris[i].replace("https://", "https4://");
                }

                uris[i] = uris[i] + "bridgeEndpoint=true" +
                        "&httpClient.connectTimeout=" + (timeOut * 1000) +
                        "&httpClient.socketTimeout=" + (timeOut.intValue() * 1000) +
                        "&httpClient.connectionRequestTimeout=" + (timeOut.intValue() * 1000) +
                        "&keepAlive=true";
            }
        }
    }

    private RestDefinition addVerb(RestDefinition abc, String verb, String uri) {
        Object answer;
        if ("get".equals(verb)) {
            answer = new GetVerbDefinition();
        } else if ("post".equals(verb)) {
            answer = new PostVerbDefinition();
        } else if ("delete".equals(verb)) {
            answer = new DeleteVerbDefinition();
        } else if ("head".equals(verb)) {
            answer = new HeadVerbDefinition();
        } else if ("put".equals(verb)) {
            answer = new PutVerbDefinition();
        } else if ("patch".equals(verb)) {
            answer = new PatchVerbDefinition();
        } else if ("options".equals(verb)) {
            answer = new OptionsVerbDefinition();
        } else {
            answer = new VerbDefinition();
            ((VerbDefinition) answer).setMethod(verb);
        }
        abc.getVerbs().add((VerbDefinition) answer);
        ((VerbDefinition) answer).setRest(abc);
        ((VerbDefinition) answer).setUri(uri);
        return abc;
    }
}
