import React, { useEffect, useState } from 'react';
import QuizQuestion from './children/QuizQuestion';
import { propTypes } from 'react-bootstrap/esm/Image';
import quizData from '../../../quiz-data/quiz-data.json';
import Axios from 'axios';
import activities from '../../../activities-data/activities v1.2.json';

const QUIZ_API_URL = "http://localhost:8080/AlterHabits/quiz/answers";

function importAllQuizImages(r) {
    let images = {};
    r.keys().map((item, index) => { images[item.replace('./', '')] = r(item); });
    return images;
}

const quizImages = importAllQuizImages(require.context('../../../images/quiz-images', false, /\.(png|jpe?g|svg)$/));

function importAllActivityImages(r) {
    let images = {};
    r.keys().map((item, index) => { images[item.replace('./', '')] = r(item); });
    return images;
}

const activityImages = importAllActivityImages(require.context('../../../images/activities', false, /\.(png|jpe?g|svg)$/));

export default function Quiz(props) {

    const [panelNumber, setPanelNumber] = useState(1);

    const question1image = quizImages['question1.jpg'];
    const question2image = quizImages['question2.jpg'];
    const question3image = quizImages['question3.jpg'];
    const question4image = quizImages['question4.jpg'];

    const [question1answer, setQuestion1answer] = useState(0);
    const [question2answer, setQuestion2answer] = useState(0);
    const [question3answer, setQuestion3answer] = useState(0);
    const [question4answer, setQuestion4answer] = useState(0);

    const [quizResults, setQuizResults] = useState([]);

    function onClickQuiz(e) {
        e.stopPropagation();
    }

    useEffect(() => {
        if (question1answer !== 0 && question2answer !== 0 && question3answer !== 0 && question4answer !== 0) {
            const firstAnswer = Object.values(quizData[0])[question2answer].value;
            const secondAnswer = Object.values(quizData[1])[question2answer].value;
            const thirdAnswer = Object.values(quizData[2])[question3answer].value;
            const fourthAnswer = Object.values(quizData[3])[question4answer].value;
            Axios.get(QUIZ_API_URL + "?answer1=" + firstAnswer + "&answer2=" + secondAnswer + "&answer3=" + thirdAnswer + "&answer4=" + fourthAnswer)
                .then(response => {
                    const activitiesResults = response.data.map(activity => {
                        return (
                            <div className="suggested-activity-container">
                                <img src={activityImages[''+activity.id+'.jpg']}></img>
                                <div className="suggested-activity-title-description">
                                    <span>{activities[activity.id - 1].name.toUpperCase()}</span>
                                    <div>
                                    {activities[activity.id - 1].description}
                                    </div>
                                </div>
                            </div>
                        )
                    })
                    setQuizResults(activitiesResults);
                })
        }
    }, [question1answer, question2answer, question3answer, question4answer])

    return (
        <div className={props.customQuizStyle} onClick={onClickQuiz}>

            {
                panelNumber === 5 ?
                    <div>
                        <div className="suggestions">Suggestions</div>
                        {quizResults}
                    </div> :
                    <>
                        <div className={panelNumber === 5 ? "not-display" : "question-indicator-container"}>
                            <div className={panelNumber === 1 ? "current-question-indicator" : "not-current-question-indicator"}></div>
                            <div className={panelNumber === 2 ? "current-question-indicator" : "not-current-question-indicator"}></div>
                            <div className={panelNumber === 3 ? "current-question-indicator" : "not-current-question-indicator"}></div>
                            <div className={panelNumber === 4 ? "current-question-indicator" : "not-current-question-indicator"}></div>
                        </div>
                        {
                            panelNumber === 1 &&
                            <QuizQuestion
                                question="1"
                                image={question1image}
                                quizInfo={quizData[0]}
                                panelNumber={panelNumber}
                                setPanelNumber={setPanelNumber}
                                question1answer={question1answer}
                                setQuestion1answer={setQuestion1answer} />
                        }
                        {
                            panelNumber === 2 &&
                            <QuizQuestion
                                question="2"
                                image={question2image}
                                quizInfo={quizData[1]}
                                panelNumber={panelNumber}
                                setPanelNumber={setPanelNumber}
                                setQuestion2answer={setQuestion2answer} />
                        }
                        {
                            panelNumber === 3 &&
                            <QuizQuestion
                                question="3"
                                image={question3image}
                                quizInfo={quizData[2]}
                                panelNumber={panelNumber}
                                setPanelNumber={setPanelNumber}
                                setQuestion3answer={setQuestion3answer} />
                        }
                        {
                            panelNumber === 4 &&
                            <QuizQuestion
                                question="4"
                                image={question4image}
                                quizInfo={quizData[3]}
                                panelNumber={panelNumber}
                                setPanelNumber={setPanelNumber}
                                setQuestion4answer={setQuestion4answer} />
                        }
                    </>
            }

        </div>
    )
}