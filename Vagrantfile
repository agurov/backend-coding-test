# -*- mode: ruby -*-
# vi: set ft=ruby :

$script = <<SCRIPT
echo I am provisioning...
date > /etc/vagrant_provisioned_at
SCRIPT

Vagrant.configure("2") do |config|
  config.vm.provision "shell", inline: $script
end

Vagrant::Config.run do |config|
  config.vm.box = "precise64"
  config.vm.box_url = "http://files.vagrantup.com/precise64.box"

  config.vm.provision "shell", path: "Vagrant-setup/bootstrap.sh", run: "always"
  
  # Port forwarding for Postgres and Application
  config.vm.forward_port 5432, 15432
  config.vm.forward_port 8080, 18080

end
