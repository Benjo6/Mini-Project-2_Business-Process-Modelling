'use strict';
var http = require('http');
var port = process.env.PORT || 1337;

http.createServer(function (req, res) {
    res.writeHead(200, { 'Content-Type': 'text/plain' });
    res.end('Hello World\n');
}).listen(port);

const prompt = require('prompt-sync')({ sigint: true });
const name = prompt("Insert your first name and last name.");
const email = prompt("Insert your email address.");
const body = prompt("Describe your complain in details, please?");

completeTask(name, email, body);




function completeTask(name, email, body) {
    const {
        Client,
        logger,
        Variables
    } = require('camunda-external-task-client-js');


    const config = {
        baseUrl: "http://localhost:8080/engine-rest",
        use: logger
    }

    const client = new Client(config);

    const handler = async ({ task, taskService }) => {
        const processVariables = new Variables()
            .set("name", name)
            .set("email", email)
            .set("formtype", "siteIssue")
            .set("body", body)

        //complete the task
        try {
            await taskService.complete(task, processVariables);
            console.alert("I completed my task successfully!!");
        }
        catch (e) {
            console.alert(`Failed completing my task, ${e}`)
        }
    };

    client.subscribe("information", handler);
}


