package com.twu.biblioteca.Router;


public class RouterContext
{
    private RouterState m_currentState;

    RouterContext(RouterState currentState)
    {
        m_currentState = currentState;
    }

    public void setNextState(RouterState state)
    {
        m_currentState = state;
    }

    RouterState getCurrentState(){
        return m_currentState;
    }
}
