package monica.files.socket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.ssl.SslContext;


/**
 * 
 * @author lucy@polarcoral.com
 *
 * 2017-08-29
 */
public class FileClientInitializer extends ChannelInitializer<SocketChannel> {

	  //  private static final ObjectDecoder DECODER = new ObjectDecoder(1024*1024,ClassResolvers.weakCachingResolver());
	    //private static final ObjectEncoder ENCODER = new ObjectEncoder();
	    
	    private static final StringDecoder DECODER = new StringDecoder();
	    private static final StringEncoder ENCODER = new StringEncoder();

	    private static final FileClientHandler CLIENT_HANDLER = new FileClientHandler();

	    private final SslContext sslCtx;

	    public FileClientInitializer(SslContext sslCtx) {
	        this.sslCtx = sslCtx;
	    }

	    @Override
	    public void initChannel(SocketChannel ch) {
	        ChannelPipeline pipeline = ch.pipeline();

	        if (sslCtx != null) {
	            pipeline.addLast(sslCtx.newHandler(ch.alloc(), FileClient.HOST, FileClient.PORT));
	        }

	        // Add the text line codec combination first,
	        pipeline.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
	        //pipeline.addLast(new ObjectDecoder(1024*1024,ClassResolvers.weakCachingResolver(this.getClass().getClassLoader())));
	        //pipeline.addLast(ENCODER);
	        
	        pipeline.addLast(DECODER);
	        pipeline.addLast(ENCODER);

	        // and then business logic.
	        pipeline.addLast(CLIENT_HANDLER);
	    }
	}