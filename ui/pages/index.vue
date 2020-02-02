<template>
  <div class="container">
    <div>
      <logo />
      <div class="dialect">
        <label>
          <input v-model="word" type="text" placeholder="方言を入力" class="dialect-input">
        </label>
        <a @click="save" class="btn-primary">保存</a>
      </div>
      <ul class="dialects">
        <li v-for="dialect in dialects" :key="dialect.id">
          <span>{{ dialect.word }}</span>
          <a @click="remove(dialect.id)" class="btn-primary btn-delete">削除</a>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import Logo from '~/components/Logo.vue'

export default {
  components: {
    Logo
  },
  data () {
    return {
      word: null
    }
  },
  async asyncData ({ app }) {
    return {
      dialects: await app.$axios.$get(`/api/dialects`)
    }
  },
  methods: {
    save () {
      this.$axios.$post('/api/dialects', { word: this.word })
        .then((response) => {
          this.refresh()
        })
    },
    remove (id) {
      this.$axios.$delete(`/api/dialects/${id}`)
        .then((response) => {
          this.refresh()
        })
    },
    refresh () {
      this.$axios.$get(`/api/dialects`)
        .then((response) => {
          this.word = null
          this.dialects = response
        })
    }
  }
}
</script>

<style>
  .container {
    margin: 0 auto;
    min-height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    text-align: center;
  }
  .dialect {
    margin: 16px 0;
  }
  .dialect-input {
    padding: 10px;
    font-family: Arial, sans-serif;
    border: solid 1px #ccc;
    width: 500px;
    border-radius: 3px;
  }
  .dialects {
    margin: 0;
    padding: 0;
  }
  .dialects li {
    list-style: none;
    text-align: left;
    vertical-align: middle;
    margin-bottom: 1em;
  }
  .dialects li span {
    display: inline-block;
    width: 500px;
  }
  .btn-primary {
    font-size: 14px;
    position: relative;
    display: inline-block;
    padding: 0.5em 1em;
    text-decoration: none;
    color: #FFF;
    background: rgb(47, 73, 94);
    border-radius: 4px;
    cursor: pointer;
  }
  .btn-delete {
    background: #ff7f7f;
  }
</style>
