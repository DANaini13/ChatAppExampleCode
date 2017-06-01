package nasoftware;

import java.util.ArrayList;


class ReciptHandler extends Thread
{
    private Holder holder;
    private int func;

    public ReciptHandler(Holder holder, int function)
    {
        this.holder = holder;
        this.func = function;
    }
    public void run()
    {
        while(!BufferPool.instructionPool.isUpdated(func-1));
        holder.completeHolder(BufferPool.instructionPool.takeout(func-1));
    }
}


public class NAManager {
    static public AccountManager accountManager =  new AccountManager();
    static public FriendsManager friendsManager =  new FriendsManager();
    static public MessagesManager messagesManager = new MessagesManager();
    static public void init()
    {
        Client client = new Client("45.56.93.181", 22000);
    }
}
