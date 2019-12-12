package pl.piotrchowaniec.currencycalc.model;

import org.springframework.stereotype.Service;

@Service
public class NbpApiUrlGenerator {

    public String generateUrl(String currencyCode) {
        StringBuilder sb = new StringBuilder().append("http://api.nbp.pl/api/exchangerates/rates/A/")
                .append(currencyCode)
                .append("/?format=json");
        return sb.toString();
    }

//    public URI getUri(String currencyCode) {
//        URI uri = UriComponentsBuilder.newInstance()
//                .scheme("http")
//                .host("api.nbp.pl")
//                .path("api/exchangerates/rates/C/")
//                .path("{currencyCode}")
//                .path("/?format=json")
//                .buildAndExpand(currencyCode).toUri();
//
//        return uri;
//    }

//    public URI getUri() {
//        UriComponents uriComponents = UriComponentsBuilder.newInstance()
//                .scheme("http")
//                .host("api.nbp.pl")
//                .path("/api/exchangerates/rates/C/")
////                .query("{currencyCode}")
//                .path("eur")
//                .path("/?format=json")
//                .build();
//
//        return uriComponents.toUri();
//    }

//    public UriComponents generateUri(String currencyCode){
//        return UriComponentsBuilder.newInstance()
//                .scheme("http")
//                .host("api.nbp.pl")
//                .path("/api/exchangerates/rates/C")
//                .path("/{currencyCode}")
//                .buildAndExpand(currencyCode);
//    }

//    public URL getUrl(String currenctCode) throws MalformedURLException {
//        return generateUri(currenctCode).toUri().toURL();
//    }
}
