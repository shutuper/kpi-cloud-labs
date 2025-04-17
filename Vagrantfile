Vagrant.configure("2") do |config|
  config.vm.box = "net9/ubuntu-24.04-arm64"

  # -----------------------------
  # BALANCER
  # -----------------------------
  config.vm.define "yehor-hnitii-ip42mp-balancer" do |bal|
    bal.vm.hostname = "yehor-hnitii-ip42mp-balancer.local"
    bal.vm.network "private_network", ip: "192.168.56.20"
    bal.vm.provider "virtualbox" do |vb|
      vb.name = "yehor-hnitii-ip42mp-balancer"
      vb.memory = 512
    end
    bal.vm.provision "ansible" do |ansible|
      ansible.playbook = "ansible/playbooks/balancer.yaml"
      ansible.inventory_path = "ansible/inventory.ini"
      ansible.limit = "yehor-hnitii-ip42mp-balancer"
      ansible.verbose = "v"
    end
  end

  # -----------------------------
  # WEB SERVER 1
  # -----------------------------
  config.vm.define "yehor-hnitii-ip42mp-web1" do |app1|
    app1.vm.hostname = "yehor-hnitii-ip42mp-web1.local"
    app1.vm.network "private_network", ip: "192.168.56.11"
    app1.vm.provider "virtualbox" do |vb|
      vb.name = "yehor-hnitii-ip42mp-web1"
      vb.memory = 1024
    end
    app1.vm.provision "ansible" do |ansible|
      ansible.playbook = "ansible/playbooks/webserver.yaml"
      ansible.inventory_path = "ansible/inventory.ini"
      ansible.limit = "yehor-hnitii-ip42mp-web1"
      ansible.verbose = "v"
    end
  end

  # -----------------------------
  # WEB SERVER 2
  # -----------------------------
  config.vm.define "yehor-hnitii-ip42mp-web2" do |app2|
    app2.vm.hostname = "yehor-hnitii-ip42mp-web2.local"
    app2.vm.network "private_network", ip: "192.168.56.12"
    app2.vm.provider "virtualbox" do |vb|
      vb.name = "yehor-hnitii-ip42mp-web2"
      vb.memory = 1024
    end
    app2.vm.provision "ansible" do |ansible|
      ansible.playbook = "ansible/playbooks/webserver.yaml"
      ansible.inventory_path = "ansible/inventory.ini"
      ansible.limit = "yehor-hnitii-ip42mp-web2"
      ansible.verbose = "v"
    end
  end

end
