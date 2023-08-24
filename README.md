# KAFKA SWING

## Synopsis

The project is a simple Java program to connect to Kafka. It uses Swing to create the GUI (Graphical User Interface).

## Motivation

I wanted to create an application that connects to Kafka to create, list, and delete topics.

## Pre Requirements

- You need to have a running Kafka server.

## Running the Application

To run the application go to KafkaSwingApplication and run it.
You'll see this screen:
![Initial screen](images/01.png)

## 1) Go to Configuration menu and select Configuration:
![Configuration](images/02.png)

![Configuration](images/03.png)

By default you'll get an Application Id and Bootstrap Servers (localhost:9092).
Information that is needed to establish a connection.

When you click on Connect button you'll see the following screen:
![Connect](images/04.png)

## 2) Go to Clusters menu and select Clusters:
![Clusters menu](images/05.png)

When you click on List Clusters button you'll see the following screen:
![Clusters](images/06.png)

## 3) Go to Topics menu and select Create Topic:
![Topics - Create Topic](images/07.png)

![Topics menu](images/08.png)

Fill the information:
![Topics form](images/09.png)

Click on Save button:
![Topics save](images/10.png)

## 4) Go to Topics menu and select List Topics:
![Topics - List Topic](images/11.png)

Click on List Topics button:
![Topics - List Topics](images/12.png)

After List Topics button clicked:
![Topics - List Topics](images/13.png)

When you select the topic, you'll see the description:
![Topics describe](images/14.png)

## License

All work is under Apache 2.0 license