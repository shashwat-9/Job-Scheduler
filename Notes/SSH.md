## SSH (Secure-shell protocol)

 - Earlier telnet was used, but it was not secure.
 - SSH uses cryptography to authenticate and encrypt connections between devices.
 - SSH establishes connection between a device and a remote server. Further it scrambles the data that could be 
decrypted by the remote server, and not any outsider.
 - Uses TCP/IP protocol suite.

 - The remote_host is the IP Address or the domain name.
 - The following cmd assumes that username on the remote system is the same as on the local.
```
    ssh remote_host
```
 - If username is different, then the following will be used :
```
    ssh remote_username@remote_host
```
 - Maybe asked to provide password to prove identity.

#### How does SSH Work?
 - It works by connecting the client program to an ssh server, called __sshd__.
 - On all linux env(s), the sshd server should start automatically. 

#### How to configure SSH
 - Changing the configuration of SSH, means we're changing the settings of sshd server.
 - The config file for sshd is located at /etc/ssh/sshd_config
 - If the config file is edited, the ssh should be reloaded.
```
    sudo systemctl reload ssh
```

#### How to Log Into SSH with Keys
 - It is faster and more secure to login using keys.
 - Key-based authentication works by creating a pair of keys: public and private.
 - public key can be shared anywhere but private key is kept secretly on the client's machine.

##### How to create SSH Keys
 - SSH keys are generated on the computer you wish to login from.
```
    ssh-keygen -t rsa
```
 - Keys will be created at ~/.ssh/id_rsa.pub and ~/.ssh/id_rsa.