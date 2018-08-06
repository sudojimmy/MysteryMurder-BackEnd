import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

public class ServiceVerticle extends AbstractVerticle {

    public static final String HOST = "localhost";
    public static final int PORT = 8080;

    private HttpServer server;

    @Override
    public void start() {
        Router router = new RouteBuilder(vertx).getRouter();

        server = vertx.createHttpServer().requestHandler(router::accept);

        server.listen(PORT, HOST, res -> {
            if (res.succeeded()) {
                System.out.println("Listening on " + HOST + ":" + PORT); // TODO: replaced by log
            } else {
                System.out.println("Fail to Listening on " + HOST + ":" + PORT);
            }
        });
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
}
