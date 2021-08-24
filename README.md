# Linux.Qemu-Raspberrypi.distro.gRPC.Server.MQTT.Paho.CPP.Yocto.Custom.App

The main target of this work is to create a gRPC server application based on Paho library in a custom build linux distribution, using the YOCTO Project/ Poky reference.

**1- Install required packages The following packages are  in Ubuntu:**
```css
	sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib \
	build-essential chrpath socat libsdl1.2-dev xterm
```
		
**2- Building Poky and using QEMU First we need to get the reference distribution (Poky).**
```css
	git clone --branch hardknott git://git.yoctoproject.org/poky
	cd pokyd
```
		
**3- Clone the openembedded layer:**
```css
	git clone --branch hardknott https://github.com/openembedded/meta-openembedded
```
		
**4- Clone the custom grpc server layer:**
```css
	git clone https://github.com/Hernado998/Yocto_RPI_gRPC-MQTT-Server_Image/meta-grpcserver
```
		
**5- Go to files folder in the meta-grpserver recipe**
```css
	cd ~/yocto/poky/meta-grpcserver/recipes-grpcserver/grpcserver/files
```
	
**6- Clone MQTT C Paho Library**
```css
	git clone -b https://github.com/eclispe/paho-mqtt-c
```
	
**7- Clone MQTT CPP Paho Library**
```css
	git clone -b https://github.com/eclipse/paho-mqtt-cpp
```
	
**8- go back to ~/yocto/poky and initialize the build environment.**
```css	
	source oe-init-build-env qemubuild
```
		
**9- Now as a final step we need to add our new layer meta-grpcserver & meta-openembedded to our configuration file ~/yocto/poky/qemubuild/conf/bblayers.conf.**
```css
	bitbake-layers add-layer ~/yocto/poky/meta-grpcserver/
	bitbake-layers add-layer ~/yocto/poky/meta-openembedded/meta-oe/
```
		 
**10- check if the layers are correctly added, go to ~/yocto/poky/qemubuild/conf/bblayers.conf or type this command:**
```css
	bitbake-layers show-layers
```
***You will see something like this:***


				layer                 path                                      
	=================================================================
	meta                  /home/nadiros/yocto/poky/meta               
	meta-yocto            /home/nadiros/yocto/poky/meta-yocto         
	meta-yocto-bsp        /home/nadiros/yocto/poky/meta-yocto-bsp     
	meta-grpcserver       /home/nadiros/yocto/poky/meta-grpcserver    
	meta-oe               /home/nadiros/yocto/poky/meta-openembedded/meta-oe

**11- Open yocto/poky/qemubuild/conf/local.conf and add these lignes:**
```css
	DISTRO_FEATURES_append = " systemd"
	DISTRO_FEATURES_BACKFILL_CONSIDERED += "sysvinit"
	VIRTUAL-RUNTIME_init_manager = "systemd"
	VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"
```
		
**12- change Machine value in the local.conf file to MACHINE ??= "qemux86-64"**
	
**13- Now we can build our custom image by running: (this can take several hours, for me it took 3~4 hours depending on the building machine)**
```css
	bitbake qemu-server-image
```
		
**14- When the build has completed we can run it with QEMU as before.**
```css
	runqemu qemux86-64
