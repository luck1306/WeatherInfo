const app = require('express')();
const server = require('http').createServer(app);
const io = require('socket.io')(server);
app.set('port', 8001);

app.get('/', (req, res) => {
    res.send("EXPRESS ROOT");
});

app.listen(app.get('port'), () => {
    console.log(app.get('port') + "'s port listened");
});