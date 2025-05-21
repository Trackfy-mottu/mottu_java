# 🛰️ Projeto de Mapeamento de Setores com Sensores

## 📋 Descrição

Este projeto tem como objetivo mapear setores de uma planta ou instalação utilizando sensores inteligentes distribuídos em pontos estratégicos. Os dados coletados em tempo real são enviados para o backend, onde são processados e disponibilizados para visualização em um aplicativo mobile.


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

