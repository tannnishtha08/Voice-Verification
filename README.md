# Voice Verification Project

Problem Statement: Everyone has had some kind of interaction with a voice assistant in their life. Often, we encounter the annoying part where the voice input does not translate correctly into the command due to noise, heavy accents, or other reasons.

## Scenario

 A user opens a voice assistant app (Google Assistant, Siri, Bixby) and starts relaying a command. The voice assistant mishears a few words and does the wrong action. The user then has to cancel that action or repeat what was said, often in the same way that the assistant heard it initially and the annoying cycle repeats.

## System

 The user interacts with a hand-held device such as a smartphone or any other device where the assistant is available. The user then voices the request and the assistant runs the voice transcription engine to understand the command and take the requested action
In this project, we would like to use crowdsourcing (such as TOLOKA) to transcribe a particular command before inputting it into the voice command. We believe that having the power of the crowd can help in resolving ambiguities in the voice recognition part. Having a wide, diverse set of “ears” can potentially overcome the difficulties faced by people when conversing with a voice assistant. We would then input this crowd-verified text into the assistant and execute the command.