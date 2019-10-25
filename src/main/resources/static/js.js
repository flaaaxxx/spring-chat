var client = null;

// metoda wyswietla wiadomosc na ekranie
function showMessage(value) {
    var newResponse = document.createElement("p");
    newResponse.appendChild(document.createTextNode(value));
    var response = document.getElementById("response");
    response.appendChild(newResponse);
}


// funkcja, ktora umozliwi poloczenie sie z protokolem STOMP
// jest ona wywolana przy starcie aplikacji
function connect() {
    // STOMP JavaScript clients will communicate to a STOMP server using a ws:// URL.
    // To create a STOMP client JavaScript object, you need to call Stomp.client(url) with the URL corresponding to the server's WebSocket endpoint:
    // client = Stomp.client("ws://localhost:8080/chat");
    client = Stomp.client("ws://flaaaxxx-chat2.herokuapp.com/chat");
    // client.connect(headers, connectCallback);
    client.connect({}, function (frame) {
        // podlaczamy sie pod "/topic/messages" czyli do kolejki i dzieki temu mozemy nasluchiwac
        client.subscribe("/topic/messages",
            // pobranie wiadomosci
            function (message) {
                // wypisanie wiadomosci
                showMessage(JSON.parse(message.body).value);
            });
    });
}
// wyslanie wiadomosci do brokera
function sendMessage() {
    var messageToSend = document.getElementById("messageToSend").value;
    // client.send(destination, {}, body);
    client.send("/app/chat", {}, JSON.stringify({
                    "value" : messageToSend}));
    // document.getElementById('messageToSend').value = "";
}
