import React, { useEffect, useState } from 'react'

export default function QuizQuestion(props) {

    const [answerSelected, setAnswerSelected] = useState(0)

    useEffect(() => {
        if (answerSelected !== 0) {
            if (props.question === "1") {
                props.setQuestion1answer(answerSelected)
            }
            if (props.question === "2") {
                props.setQuestion2answer(answerSelected)
            }
            if (props.question === "3") {
                props.setQuestion3answer(answerSelected)
            }
            if (props.question === "4") {
                props.setQuestion4answer(answerSelected)
            }
        }
    }, [answerSelected])

    return (
        <div className="question-container">
            <div className="question-photo">
                <img src={props.image}></img>
                <div>{props.quizInfo.question}</div>
            </div>
            <div className="question-answers-container">
                <div className={answerSelected === 1 ? "answers-container answer-selected" : "answers-container"} numberofanswer="1" onClick={() => setAnswerSelected(1)}><span>1. {props.quizInfo.answer1.text}</span></div>
                <div className={answerSelected === 2 ? "answers-container answer-selected" : "answers-container"} numberofanswer="2" onClick={() => setAnswerSelected(2)}><span>2. {props.quizInfo.answer2.text}</span></div>
                <div className={answerSelected === 3 ? "answers-container answer-selected" : "answers-container"} numberofanswer="3" onClick={() => setAnswerSelected(3)}><span>3. {props.quizInfo.answer3.text}</span></div>
            </div>
            <div className="next-or-submit-button-container">
                <button className="next-or-submit-button" disabled={answerSelected === 0 ? true : false} onClick={() => props.setPanelNumber(props.panelNumber + 1)}>{props.panelNumber === 4 ? "Submit" : "Next"}</button>
            </div>
        </div>
    )
}