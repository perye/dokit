const state = {
  errorLog: [],
  warnLog: []
}

const mutations = {
  ADD_ERROR_LOG: (state, log) => {
    state.errorLog.push(log)
  },
  CLEAR_ERROR_LOG: (state) => {
    state.errorLog.splice(0)
  },

  ADD_WARN_LOG: (state, log) => {
    state.warnLog.push(log)
  },
  CLEAR_WARN_LOG: (state) => {
    state.warnLog.splice(0)
  }
}

const actions = {
  addErrorLog({ commit }, log) {
    commit('ADD_ERROR_LOG', log)
  },
  clearErrorLog({ commit }) {
    commit('CLEAR_ERROR_LOG')
  },

  addWarnLog({ commit }, log) {
    commit('ADD_WARN_LOG', log)
  },
  clearWarnLog({ commit }) {
    commit('CLEAR_WARN_LOG')
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
