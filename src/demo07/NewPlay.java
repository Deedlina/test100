package demo07;

/** 
 * @ClassName: NewPlay 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author win10 
 * @date 2017年6月21日 上午11:42:16  
 */

public class NewPlay extends Playing implements Player {

    /*   
     * @see demo07.Player#play() 
     */
    @Override
    public void play() {
        display("newPlay.play()");
    }

    /* 
     * @see demo07.Player#pause() 
     */
    @Override
    public void pause() {
        display("newPlay.pause()");
    }

    /*  
     * @see demo07.Player#stop() 
     */
    @Override
    public void stop() {
        display("newPlay.stop()");
    }

    /*   
     * @see demo07.Playing#winRun() 
     */
    @Override
    void winRun() {
        display("newPlay.winRun()");
    }
    
    public static void main(String[] args)
    {
      NewPlay p = new NewPlay();
      p.play();
      p.pause();
      p.stop();
      p.winRun();
    }

}
