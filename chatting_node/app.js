const app = require('express')();
const server = require('http').createServer(app);
const io = require('socket.io')(server);
require('dotenv').config();

app.set('port', 8001);

app.get('/', (req, res) => {
    res.send(`EXPRESS ROOT + ${process.env.MESSAGE}`);
});

app.listen(app.get('port'), () => {
    console.log(app.get('port') + "'s port listened");
});