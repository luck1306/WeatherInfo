import express from "express";
import { createServer } from "node:http";
import { config } from "dotenv";
import { Server } from "socket.io";
import cors from "cors";

const app = express();
const server = createServer(app);
const io = new Server(server, {path: "/socket.io"});
const roomArr = [];

config();
app.set("port", process.env.PORT);
app.use(cors({ origin: "*", credentials: true }));

app.get("/", (req, res) => {
    res.send(`EXPRESS ROOT : ${process.env.MESSAGE}`);
});

io.on("connection", (socket) => {
    console.log("connected");

    // make chatting room between client and admin
    socket.on("OPEN-CHAT", (data) => {
        if (data.id) {
            console.log(data.id);
        }
    }); // OPEN-CHAT event

    // message of the user who chat send the other user
    socket.on("CHAT", (data) => {
        //
    }); // CHAT event

    socket.on("DISCONNECT", () => {
        console.log("user disconnected: " + socket.name);
    });
});

server.listen(app.get("port"), () => {
    console.log(app.get("port") + `'s port listened`);
});