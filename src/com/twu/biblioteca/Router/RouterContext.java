package com.twu.biblioteca.Router;

/**
 * Created by xuewang on 8/1/16.
 */
public class RouterContext
{
    RouterState m_currentState;

    public RouterContext(RouterState currentState)
    {
        m_currentState = currentState;
    }

    public void setNextState(RouterState state)
    {
        m_currentState = state;
    }

    public RouterState getCurrentState(){
        return m_currentState;
    }
}
