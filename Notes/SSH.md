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

### Basic Connection Instructions

#### Connecting to a Remote Server
 - To connect to a remote linux server, we can use ssh command.
 - If the username on the local machine is same as that for remote server, then we can use :
```shell
    ssh remote_host
```
 - If the username is different for remote server, then
```shell
    ssh username@remote_host
```
 - If password authentication is used, then password will be required.
 - If keys are used for authentication, and they have associated private key passphrase, then it will be required.
 - Else the connection will be established.

- To run a single cmd on a remote server, we can use :
```shell
    ssh username@remote_host cmd_to_rum
```
 - Here the connection will be closed after this cmd is executed.

#### Logging in to a server with a different port
 - By default, ssh daemon on a server runs on port 22.
 - If that is not the case, and it is running on a non-standard port, then we can ssh as follows:
```shell
    ssh -p port_num username@remote_host
```
 - To avoid this, we can edit the ~./ssh/config file, and put the port there
```shell
    Host remote_alias
    HostName remote_host
    Port port_num
```

#### Server-Side Configuration Options

##### Disabling Password Authentication
 - If the SSH keys are working fine, it is a good idea to turn off the password authentication.
 - To do this, on the remote server, open the /etc/ssh/sshd_config with sudo or root privileges.
 - Set the PasswordAuthentication to __no__ value.
 - Then restart the SSH service,
On Ubuntu/Debian
```shell
    sudo service ssh restart
```

##### To Change the port on SSH Daemon server
 - open etc/ssh/sshd_config
 - change Port value to any value
 - restart the ssh service

