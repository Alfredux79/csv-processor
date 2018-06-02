# Spring Integration Practice Project: csv-processor

This is a SpringBoot project to do very simple practice of the [enterprise integration patterns](http://www.enterpriseintegrationpatterns.com/) using the spring framework.

## System Description:

The system does the following:

- reads a csv file from a folder using an inbound [channel adapter](http://www.enterpriseintegrationpatterns.com/patterns/messaging/ChannelAdapter.html)
- copies this file to a [channel](http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessageChannel.html) 
- a [transformer](http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessageTranslator.html) reads the file from the channel and transorms it to a byte array and sends it  to another data channel
- a [recipipent-list-router](http://www.enterpriseintegrationpatterns.com/patterns/messaging/RecipientList.html) sends the message to two different channels, one for processing and one for saving a backup of the processed file
- a [service activator](http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessagingAdapter.html) calls a service to process the file from the processing channel and store it's contents in a relation database
- and outbound [channel adapter](http://www.enterpriseintegrationpatterns.com/patterns/messaging/ChannelAdapter.html) ends the circuit on the backup side saving the file to the processed folder.

![spring-integration-diagram](https://user-images.githubusercontent.com/23134342/40877852-ca8b0ef0-6687-11e8-8185-a76a66bffb94.png)

## Usage:

```
git clone https://github.com/Alfredux79/csv-processor.git
mvn spring-boot:run
```
