package com.example.bottomnavigationsample.data

import com.tinder.scarlet.ws.Receive
import com.tinder.scarlet.ws.Send
import kotlinx.coroutines.flow.Flow

interface SocketService {
    @Send
    fun sendSubscribe(subscribe: Subscribe)

//    @Receive
//    fun observeOnConnectionOpenedEvent(): Flow<WebSocket.Event>
    @Receive
    fun observePrice(): Flow<RawSocketObj>
}