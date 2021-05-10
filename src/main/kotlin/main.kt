import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpRequest.BodyPublishers.noBody
import java.net.http.HttpResponse


class APIs {
//    val client = HttpClient.newBuilder().build()
//    val requestHeader = HttpRequest.newBuilder()
//        .uri(URI.create("https://applied.multiverse.io"))
//        .build();
//    val response = client.send(requestHeader, HttpResponse.BodyHandlers.ofString())
//    println(response.body())
}

fun main(args: Array<String>) {

    val url = "https://http-challenge.multiverse-coaches.io"

    try {
        val client = HttpClient.newHttpClient()

        // first request (GET)
        val request = HttpRequest.newBuilder(
            URI.create(url))
            .header("accept", "application/json")
            .method("GET", noBody())
            .build()
        println(request)
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        println(response.body())

        // --------------------------------------------------
        // TODO - add code for second request (POST) here
        //  .method("POST", HttpRequest.BodyPublishers.ofString(jsonName))


        val userReq = """{"name": "Jeffery"}"""
        val secondRequest = HttpRequest.newBuilder(
            URI.create("$url/apprentices"))
            .header("content-type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(userReq))
            .build()
        println(secondRequest)
        val secondResponse = client.send(secondRequest, HttpResponse.BodyHandlers.ofString())
        println("Second Response")
        println(secondResponse.body())

        // The code below will help you retrieve the "your-id" header from the HTTP Response

        val srHeaders = secondResponse.headers().map()
        for (i in srHeaders) {
            if (i.key.toString() == "your-id") {
                val lopI = i.value[0];
                println(lopI)
            }
        }

//        Map<String, List<String>> map = headers.map();
//        for (Map.Entry<String, List<String>> entry:map.entrySet()) {
//            if ("your-id".equalsIgnoreCase(entry.getKey())) {
//                headerValue = entry.getValue().get(0);
//                break;
//            }
//        }

        // TODO - add code for third request (header) here
        val thirdResponse = HttpRequest.newBuilder()

        // TODO - add code for forth request (PATCH) here


        // TODO - add code for fifth request (GET with Query Parameters) here
    } catch (e: Exception) {
        e.printStackTrace()
    }

    APIs()
}