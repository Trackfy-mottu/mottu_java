# 🛰️ Projeto de Mapeamento de Setores com Sensores

## 📋 Descrição

Este projeto tem como objetivo mapear setores de uma planta ou instalação utilizando sensores inteligentes distribuídos em pontos estratégicos. Os dados coletados em tempo real são enviados para o backend, onde são processados e disponibilizados para visualização em um aplicativo mobile.

---

## 👥 Responsáveis pelo Projeto

- Guilherme Alves Pedroso - RM555357
- João Vitor Silva Nascimento - RM554694
- Rafael Souza Bezerra - 557888

---

## 📱 Frontend (Mobile)

- **Tecnologia**: React Native (ou Flutter/Outros — definir)
- **Funcionalidades**:
  - Visualização em tempo real dos setores mapeados.
  - Navegação por setores e leitura de informações detalhadas.
  - Interface responsiva e otimizada para dispositivos móveis.

---

## 🖥️ Backend

O backend é dividido em dois módulos:

### 🔹 Java (Processamento e Integração com Sensores)

- **Tecnologia**: Spring Boot
- **Responsabilidades**:
  - Receber e tratar os dados brutos enviados pelos sensores.
  - Realizar o pré-processamento e validação dos dados.

### 🔸 C# (Camada de Negócio e Autenticação)

- **Tecnologia**: .NET 8 Web API
- **Responsabilidades**:
  - Autenticação e autorização de usuários.
  - Regras de negócio relacionadas aos setores e permissões de acesso.

---

# 🚀 Executar a aplicação Java Spring Boot pronta

---

## ✅ Pré-requisitos

Antes de iniciar, certifique-se de ter instalado:

- [Java JDK 17 ou superior](https://adoptium.net/)
- [Maven](https://maven.apache.org/) ou use o Maven wrapper (`./mvnw`)
- (Opcional) [Spring Boot CLI](https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html#getting-started.installing.cli)

---

## ▶️ Executando a aplicação

### 1. Acesse o diretório do projeto

```bash
cd nome-do-seu-projeto
```

### 2. Execute com Maven

Se você estiver usando Maven instalado globalmente:

```bash
mvn spring-boot:run
```

## 🚀 Passo a Passo de Execução

### ✅ Passo 1 - Criação do Resource Group no Azure via CLI

```bash
az group create -l eastus -n rg-vm-challenge
```

---

### ✅ Passo 2 - Criação da VM Linux no Azure via CLI

```bash
az vm create --resource-group rg-vm-challenge --name vm-challenge --image Canonical:ubuntu-24_04-lts:minimal:24.04.202505020 --size Standard_B2s --admin-username admin_fiap --admin-password admin_fiap@123
```

---

### ✅ Passo 3 - Criação da NSG com prioridade 1010 no Azure via CLI

```bash
az network nsg rule create --resource-group rg-vm-challenge --nsg-name vm-challengeNSG --name port_8080 --protocol tcp --priority 1010 --destination-port-range 8080
```

---

### ✅ Passo 4 - Criação da NSG com prioridade 1020 no Azure via CLI

```bash
az network nsg rule create --resource-group rg-vm-challenge --nsg-name vm-challengeNSG --name port_80 --protocol tcp --priority 1020 --destination-port-range 80
```

---

### ✅ Passo 5 - Abrir portas necessárias ao projeto via CLI

```bash
az vm open-port --port 80 --resource-group rg-vm-challenge --name vm-challenge
```

Realizar o acesso via SSH:

```bash
ssh admin_fiap@IP
```

---

### ✅ Passo 6 - Instalar o Docker na VM via SSH

```bash
sudo apt-get update
sudo apt-get install ca-certificates curl
sudo install -m 0755 -d /etc/apt/keyrings
sudo curl -fsSL https://download.docker.com/linux/ubuntu/gpg -o /etc/apt/keyrings/docker.asc
sudo chmod a+r /etc/apt/keyrings/docker.asc
```

Adicionar o repositório do Docker:

```bash
echo   "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.asc] https://download.docker.com/linux/ubuntu   $(. /etc/os-release && echo "${UBUNTU_CODENAME:-$VERSION_CODENAME}") stable" |   sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
```

Instalar o Docker:

```bash
sudo apt-get update
sudo apt-get install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
```

---

### ✅ Passo 7 - Executar o container do projeto

Baixar a imagem:

```bash
sudo docker pull rafabezerra/mottu_challenge:latest
```

Executar o container:

```bash
sudo docker run -d -p 8080:8080 rafabezerra/mottu_challenge
```
